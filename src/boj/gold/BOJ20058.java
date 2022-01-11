package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ20058 {
    static int N, Q, land, totalIce;
    static int[][] A;
    static int[] L;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2, N);
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        L = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void findBiggest() {
        boolean[][] visit = new boolean[N][N];
        Stack<int[]> stack = new Stack<>();
        land = 0;
        totalIce = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] > 0 && !visit[i][j]) {
                    stack.push(new int[]{i, j});
                    visit[i][j] = true;
                    totalIce += A[i][j];
                    int cnt = 1;
                    while (!stack.isEmpty()) {
                        int[] temp = stack.pop();
                        int r = temp[0];
                        int c = temp[1];
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dir[k][0];
                            int nc = c + dir[k][1];
                            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                            if(visit[nr][nc]) continue;
                            if (A[nr][nc] > 0) {
                                cnt++;
                                visit[nr][nc] = true;
                                stack.push(new int[]{nr, nc});
                                totalIce += A[nr][nc];
                            }
                        }
                    }
                    land = Math.max(cnt, land);
                }
            }
        }
    }

    static void rotate(int r, int c, int L, int[][] temp) {
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                temp[r + j][c + L - i - 1] = A[r + i][c + j];
            }
        }
    }

    static int[][] divide(int L) {
        int[][] temp = new int[N][N];
        L = (int) Math.pow(2, L);

        for (int i = 0; i < N; i+=L) {
            for (int j = 0; j < N; j+=L) {
                rotate(i, j, L, temp);
            }
        }

        return temp;
    }

    static int[][] melt() {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            temp[i] = Arrays.copyOf(A[i], N);
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int cnt = 0;
                if(A[r][c] == 0) continue;

                for (int k = 0; k < 4; k++) {
                    int nx = r + dir[k][0];
                    int ny = c + dir[k][1];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (A[nx][ny] > 0) {
                        cnt++;
                    }
                }
                if (cnt < 3) {
                    temp[r][c]--;
                }
            }
        }
        return temp;
    }

    static void solve() {
        for (int i = 0; i < Q; i++) {
            A = divide(L[i]);
            A = melt();
        }
        findBiggest();

        System.out.println(totalIce);
        System.out.println(land);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
