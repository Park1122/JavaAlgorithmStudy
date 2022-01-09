package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17142 {
    static class Virus {
        int x, y, time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int N, M, ans, emptySpace;
    static int[][] map;
    static ArrayList<Virus> viruses;
    static Virus[] active;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        active = new Virus[M];
        viruses = new ArrayList<>();
        emptySpace = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    emptySpace++;
                } else if (map[i][j] == 2) {
                    viruses.add(new Virus(i, j, 0));
                }
            }
        }
        ans = Integer.MAX_VALUE;
    }

    // M개 뽑은 바이러스 퍼뜨리기
    static void bfs(int emptySpace) {
        Queue<Virus> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            Virus v = active[i];
            visit[v.x][v.y] = true;
            q.add(v);
        }

        while (!q.isEmpty()) {
            Virus now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dir[d][0];
                int ny = now.y + dir[d][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 맵 밖인 경우
                if(visit[nx][ny]) continue; // 이미 퍼진 경우
                if(map[nx][ny] == 1) continue; // 벽인 경우

                if (map[nx][ny] == 0) {
                    emptySpace--;
                }
                if (emptySpace == 0) {
                    ans = Math.min(ans, now.time + 1);
                    return;
                }
                visit[nx][ny] = true;
                q.add(new Virus(nx, ny, now.time + 1));
            }
        }
    }

    // 바이러스 M개 뽑기
    static void recFunc(int start, int cnt) {
        if (cnt == M) {
            bfs(emptySpace);
        } else {
            for (int i = start; i < viruses.size(); i++) {
                active[cnt] = viruses.get(i);
                recFunc(i + 1, cnt + 1);
            }
        }
    }

    static void solve() {
        if (emptySpace == 0) {
            System.out.println(0);
        } else {
            recFunc(0, 0);
            if (ans == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
