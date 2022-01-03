package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {
    static int N, M, ans;
    static int[][] scores;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    // ㅜ 일때 모든 경우 (ㅜ,ㅗ,ㅓ,ㅏ 순)
    static int[][] ex = {{0, 0, 0, 1}, {1, 1, 1, 0}, {0, 1, 2, 1}, {0, 1, 2, 1}}; //세로
    static int[][] ey = {{0, 1, 2, 1}, {0, 1, 2, 1}, {1, 1, 1, 0}, {0, 0, 0, 1}}; //가로
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        scores = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[N][M];
    }

    static void specialCase(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int sum = 0;
            boolean isOut = false;

            for (int k = 0; k < 4; k++) {
                int nx = x + ex[d][k];
                int ny = y + ey[d][k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    isOut = true;
                    continue;
                }
                sum += scores[nx][ny];
            }

            if (!isOut) {
                ans = Math.max(sum, ans);
            }
        }
    }

    static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            ans = Math.max(sum, ans);
            return;
        } else {
            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny]) continue;

                visit[nx][ny] = true;
                dfs(nx, ny, sum + scores[nx][ny], depth + 1);
                visit[nx][ny] = false;
            }
        }
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // ㅗ, ㅓ, ㅜ, ㅏ 를 제외한 나머지 케이스들은 depth = 4인 dfs로 찾기 가능
                visit[i][j] = true;
                dfs(i, j, scores[i][j], 1);
                visit[i][j] = false;

                // ㅗ, ㅓ, ㅜ, ㅏ인 경우
                specialCase(i, j);
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
