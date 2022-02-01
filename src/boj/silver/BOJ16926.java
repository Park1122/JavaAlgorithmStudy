package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {
    static int n, m, r;
    static int[][] A;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        // 회전해야할 사각형 개수
        int groupCnt = Math.min(n, m) / 2;

        // r번 회전
        while (r-- > 0) {
            for (int i = 0; i < groupCnt; i++) {
                int direction = 0;
                int startX = i;
                int startY = i;
                int temp = A[startX][startY];

                while (direction < 4) {
                    int nx = startX + dir[direction][0];
                    int ny = startY + dir[direction][1];

                    // 사각형을 안 벗어난 경우에는 계속 돌림
                    if (nx >= i && ny >= i && nx < n - i && ny < m - i) {
                        A[startX][startY] = A[nx][ny];
                        startX = nx;
                        startY = ny;
                    } else {
                        direction++;
                    }
                }

                A[i + 1][i] = temp;
            }
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(A[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
