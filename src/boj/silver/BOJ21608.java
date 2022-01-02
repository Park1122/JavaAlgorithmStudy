package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ21608 {
    static int n;
    static long ans;
    static int[] order;
    static int[][] room;
    static ArrayList<Integer>[] adj;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n * n + 1];
        order = new int[n * n + 1];
        room = new int[n][n];
        for (int i = 1; i <= n * n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            order[i] = student;
            for (int j = 0; j < 4; j++) {
                adj[student].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    static int findFriend(int r, int c, int me) {
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int nx = r + dir[d][0];
            int ny = c + dir[d][1];
            if(nx < 0 || ny < 0 || nx >= n || ny >= n || room[nx][ny] == 0) continue;
            if (adj[me].contains(room[nx][ny])) {
                cnt++;
            }
        }
        return cnt;
    }

    static int findBlank(int r, int c) {
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int nx = r + dir[d][0];
            int ny = c + dir[d][1];
            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (room[nx][ny] == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    static void batch() {
        for (int i = 1; i <= n * n; i++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) {
                    if (a[1] == b[1]) {
                        if (a[2] == b[2]) {
                            return a[3] - b[3]; // 열 번호 작은 순
                        }
                        return a[2] - b[2]; // 행 번호 작은 순
                    }
                    return b[1] - a[1]; // 빈칸 많은 순
                }
                return b[0] - a[0]; // 친구 많은 순
            });

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (room[r][c] != 0) continue;
                    int friendNum = findFriend(r, c, order[i]);
                    int blankNum = findBlank(r, c);
                    pq.add(new int[]{friendNum, blankNum, r, c});
                }
            }

            int[] best = pq.poll();
            int nx = best[2];
            int ny = best[3];
            room[nx][ny] = order[i];
        }
    }

    static void calculate() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int stNum = room[i][j];
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dir[d][0];
                    int ny = j + dir[d][1];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (adj[stNum].contains(room[nx][ny])) {
                        cnt++;
                    }
                }

                if (cnt == 1) {
                    ans += 1;
                } else if (cnt == 2) {
                    ans += 10;
                } else if (cnt == 3) {
                    ans += 100;
                } else if (cnt == 4) {
                    ans += 1000;
                }
            }
        }
    }

    static void solve() {
        // 자리 배치
        batch();

        // 만족도 계산
        calculate();

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
