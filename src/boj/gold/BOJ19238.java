package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-19238-%EC%8A%A4%ED%83%80%ED%8A%B8-%ED%83%9D%EC%8B%9C-java
 */
public class BOJ19238 {
    // 출발지
    static class Node implements Comparable<Node>{
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist == o.dist) {
                if (this.x == o.x) {
                    return this.y - o.y;
                } else {
                    return this.x - o.x;
                }
            }
            return this.dist - o.dist;
        }
    }

    // 출발지와 도착지 정보
    static class Path {
        int sx, sy, ex, ey;

        public Path(int sx, int sy, int ex, int ey) {
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
        }
    }

    static int N, M, fuel;
    static int tx, ty; // 택시의 좌표
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<Node> startList;
    static ArrayList<Path> pathList;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    map[i][j] = -1;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        tx = Integer.parseInt(st.nextToken());
        ty = Integer.parseInt(st.nextToken());
        startList = new ArrayList<>();
        pathList = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
            pathList.add(new Path(x, y, nx, ny));
            map[x][y] = i;
        }
    }

    static int getDist(int startX, int startY, int endX, int endY) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == endX && now.y == endY) {
                return now.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dir[d][0];
                int ny = now.y + dir[d][1];
                if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if(map[nx][ny] == -1) continue;
                if(visit[nx][ny]) continue;

                visit[nx][ny] = true;
                q.add(new Node(nx, ny, now.dist + 1));
            }
        }
        return -1;
    }

    static void setStart(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, y, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (map[now.x][now.y] >= 1) {
                startList.add(new Node(now.x, now.y, now.dist));
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dir[d][0];
                int ny = now.y + dir[d][1];
                if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if(map[nx][ny] == -1) continue;
                if(visit[nx][ny]) continue;

                visit[nx][ny] = true;
                pq.add(new Node(nx, ny, now.dist + 1));
            }
        }
    }

    static void solve() {
        boolean flag = false;

        while (true) {
            // 1. 손님을 모두 데려다 준 경우 종료
            if (pathList.isEmpty()) {
                System.out.println(fuel);
                return;
            }

            // 2. 가장 가까운 출발지 선정
            startList.clear();
            visit = new boolean[N + 1][N + 1];
            setStart(tx, ty); // 출발지 선정

            // 2-1. 벽에 막혀 출발지로 못 가는 경우 종료
            if (startList.isEmpty()) { // 벽에 막힌 경우
                System.out.println(-1);
                return;
            }

            // 3. 출발지까지 이동시 소모된 연료 빼기
            Node start = startList.get(0);
            map[start.x][start.y] = 0;
            fuel -= start.dist;
            // 2-2. 출발지로 이동 중 연료가 떨어진 경우
            if (fuel < 0) {
                System.out.println(-1);
                break;
            }

            visit = new boolean[N + 1][N + 1];
            int dist = 0;
            for (int i = 0; i < pathList.size(); i++) { // 도착지 선정
                Path p = pathList.get(i);

                if (p.sx == start.x && p.sy == start.y) {
                    // 4. 도착지까지 가장 가까운 경로 선정
                    dist = getDist(p.sx, p.sy, p.ex, p.ey);
                    // 4-1. 벽에 막혀 도착지로 못 가는 경우 종료
                    if (dist == -1) {
                        System.out.println(-1);
                        return;
                    }
                    tx = p.ex;
                    ty = p.ey;
                    pathList.remove(p);
                    break;
                }
            }
            
            // 5. 도착지까지 이동하여 소모한 연료 빼기
            fuel -= dist;
            // 4-2. 도착지로 가는 도중 연료가 떨어진 경우 종료
            if (fuel < 0) { // 연료 떨어진 경우
                System.out.println(-1);
                return;
            }
            // 6. 도착지까지 소모된 연료의 2배 충전
            fuel += dist * 2;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
