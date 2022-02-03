package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4396 {
    static int n;
    static String[] map, play;
    static String[][] ans;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new String[n];
        play = new String[n];
        ans = new String[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }
        for (int i = 0; i < n; i++) {
            play[i] = br.readLine();
        }
    }

    static void solve() {
        boolean isClicked = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int mineCnt = 0;
                // 열린 곳
                if(play[i].charAt(j) == 'x') {
                    if (map[i].charAt(j) == '*') { // 지뢰 밟은 경우
                        isClicked = true;
                    } else { // 안 밟은 경우
                        // 8방향 확인하면서 지뢰 개수 계산
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dir[d][0];
                            int ny = j + dir[d][1];

                            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                            if(map[nx].charAt(ny) == '*') {
                                mineCnt++;
                            }
                        }

                        ans[i][j] = String.valueOf(mineCnt);
                    }
                }else{ // 안 열린 곳
                    ans[i][j] = ".";
                }
            }
        }
        if (isClicked) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i].charAt(j) == '*') {
                        ans[i][j] = "*";
                    }
                }
            }
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(ans[i][j]);
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
