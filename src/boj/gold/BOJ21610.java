package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ21610 {
    static int N, M;
    static int[][] A, move;
    static ArrayList<int[]> clouds;
    static boolean[][] visit;
    static int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static int[][] ddir = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1][N + 1];
        move = new int[M][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            move[i][0] = Integer.parseInt(st.nextToken()) - 1;
            move[i][1] = Integer.parseInt(st.nextToken());
        }
        clouds = new ArrayList<>();
        clouds.add(new int[]{N, 1});
        clouds.add(new int[]{N, 2});
        clouds.add(new int[]{N - 1, 1});
        clouds.add(new int[]{N - 1, 2});
    }

    static int cal() {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                cnt += A[i][j];
            }
        }
        return cnt;
    }

    static void solve() {
        for (int i = 0; i < M; i++) {
            visit = new boolean[N + 1][N + 1];
            int d = move[i][0];
            int s = move[i][1];

            // 구름 이동
            for (int[] cloud : clouds) {
                int nx = cloud[0] + dir[d][0] * s;
                int ny = cloud[1] + dir[d][1] * s;
                while (nx < 1 || nx > N) {
                    nx = nx < 1 ? nx + N : nx - N;
                }
                while (ny < 1 || ny > N) {
                    ny = ny < 1 ? ny + N : ny - N;
                }
                visit[nx][ny] = true;
                cloud[0] = nx;
                cloud[1] = ny;
            }

            // 비내리기
            for (int[] cloud : clouds) {
                A[cloud[0]][cloud[1]]++;
            }

            // 물복사버그 마법 시전
            for (int[] cloud : clouds) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = cloud[0] + ddir[k][0];
                    int ny = cloud[1] + ddir[k][1];
                    if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
                    if(A[nx][ny] == 0) continue;
                    cnt++;
                }
                A[cloud[0]][cloud[1]] += cnt;
            }
            clouds.clear();

            // 구름 생성
            for (int x = 1; x <= N; x++) {
                for (int y = 1; y <= N; y++) {
                    if (A[x][y] >= 2 && !visit[x][y]) {
                        A[x][y] -= 2;
                        clouds.add(new int[]{x, y});
                    }
                }
            }
        }

        System.out.println(cal());
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
