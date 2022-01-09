package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17779 {
    static int N, total, min;
    static int[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }
        min = Integer.MAX_VALUE;
    }

    static void calculate(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[N][N];

        // 경계선 세팅
        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        int[] sectionTotal = new int[5];

        // 1구역
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if(border[i][j]) break;
                sectionTotal[0] += map[i][j];
            }
        }

        // 2구역
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (border[i][j]) break;
                sectionTotal[1] += map[i][j];
            }
        }

        // 3구역
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                sectionTotal[2] += map[i][j];
            }
        }

        // 4구역
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                sectionTotal[3] += map[i][j];
            }
        }

        // 5구역
        sectionTotal[4] = total;

        for (int i = 0; i < 4; i++) {
            sectionTotal[4] -= sectionTotal[i];
        }
        
        // 크기 순 정렬
        Arrays.sort(sectionTotal);

        // 갱신
        min = Math.min(min, sectionTotal[4] - sectionTotal[0]);
    }

    static void solve() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if(x + d1 + d2 >= N) continue;
                        if(y - d1 < 0 || y + d2 >= N) continue;

                        calculate(x, y, d1, d2);
                    }
                }
            }
        }

        System.out.println(min);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
