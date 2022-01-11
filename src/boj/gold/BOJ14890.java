package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14890 {
    static int N, L, ans;
    static int[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
    }

    // flag -> true: 행, false: 열
    static boolean checkPath(int x, int y, boolean flag) {
        int[] height = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (flag) {
                height[i] = map[x][i];
            } else {
                height[i] = map[i][y];
            }
        }

        for (int i = 0; i < N - 1; i++) {
            if (height[i] == height[i + 1]) { // 높이가 같은 경우
                continue;
            } else if (height[i] - height[i + 1] == 1) { // 높이가 내려가는 경우
                for (int j = i + 1; j <= i + L; j++) {
                    // 범위가 넘어가거나 칸의 높이가 다르거나 이미 경사로가 있는 경우
                    if (j >= N || height[i + 1] != height[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            } else if (height[i] - height[i + 1] == -1) { // 높이가 올라가는 경우
                for(int j=i; j>i-L; j--) {
                    // 범위 넘어가거나 칸의 높이가 다르거나 이미 경사로가 있는 경우
                    if (j < 0 || height[i] != height[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            } else { // 2칸이상 차이나는 경우(길이 아님)
                return false;
            }
        }
        return true;
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            // 행 검사
            if (checkPath(i, 0, true)) {
                ans++;
            }
            // 열 검사
            if (checkPath(0, i, false)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
