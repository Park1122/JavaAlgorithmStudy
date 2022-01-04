package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15683 {
    static class CCTV {
        int num, x, y;

        public CCTV(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, ans;
    static int[][] map, temp;
    static int[] output;
    static ArrayList<CCTV> cctvList;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cctvList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new CCTV(map[i][j], i, j));
                }
            }
        }
        ans = Integer.MAX_VALUE;
        output = new int[cctvList.size()]; // 순열을 담을 배열
    }

    // BFS로 방향에 맞게 감시
    static void watch(CCTV cctv, int d) {
        Queue<CCTV> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][m];

        q.add(cctv);
        visit[cctv.x][cctv.y] = true;

        while (!q.isEmpty()) {
            CCTV c = q.poll();
            int nx = c.x + dir[d][0];
            int ny = c.y + dir[d][1];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m || temp[nx][ny] == 6) break;

            if (temp[nx][ny] == 0) { // 빈칸의 경우 감시 가능
                temp[nx][ny] = -1;
                q.add(new CCTV(cctv.num, nx, ny));
            } else { // 감시 불가능한 경우
                q.add(new CCTV(cctv.num, nx, ny));
            }
        }
    }

    // 각 cctv 번호와 순열로 뽑혀진 방향에 맞게 감시
    static void direction(CCTV cctv, int d) {
        int num = cctv.num;
        if (num == 1) {
            if(d==0) watch(cctv, 0); // 상
            else if(d==1) watch(cctv, 1); // 우
            else if(d==2) watch(cctv, 2); // 하
            else if(d==3) watch(cctv, 3); // 좌
        } else if (num == 2) {
            if (d == 0 || d == 2) {
                watch(cctv, 0);
                watch(cctv, 2);
            } else {
                watch(cctv, 1);
                watch(cctv, 3);
            }
        } else if (num == 3) {
            if (d == 0) {
                // 상우
                watch(cctv, 0);
                watch(cctv, 1);
            } else if (d == 1) {
                // 우하
                watch(cctv, 1);
                watch(cctv, 2);
            } else if (d == 2) {
                // 하좌
                watch(cctv, 2);
                watch(cctv, 3);
            } else if (d == 3) {
                // 좌상
                watch(cctv, 0);
                watch(cctv, 3);
            }
        } else if (num == 4) {
            if (d == 0) {
                // 좌상우
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 3);
            } else if (d == 1) {
                // 상우하
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 2);
            } else if (d == 2) {
                // 좌하우
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 3);
            } else if (d == 3) {
                // 상좌하
                watch(cctv, 0);
                watch(cctv, 2);
                watch(cctv, 3);
            }
        } else if (num == 5) {
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }
    }

    // DFS로 상하좌우 4방향 중에서 cctv의 총 개수, r만큼을 순서대로 뽑는 순열
    static void permu(int depth, int r) {
        if (depth == r) {
            temp = new int[n][m];
            for (int i = 0; i < map.length; i++) {
                System.arraycopy(map[i], 0, temp[i], 0, map[i].length);
            }

            // cctv번호와 순열로 뽑혀진 방향에 맞는 상하좌우 방향 설정
            for (int i = 0; i < cctvList.size(); i++) {
                direction(cctvList.get(i), output[i]);
            }

            getBlindSpot();
            return;
        }
        for (int i = 0; i < 4; i++) {
            output[depth] = i;
            permu(depth + 1, r);
        }
    }

    // 사각지대 구하기
    static void getBlindSpot() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) {
                    cnt++;
                }
            }
        }
        ans = Math.min(ans, cnt);
    }

    static void solve() {
        permu(0, cctvList.size());
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
