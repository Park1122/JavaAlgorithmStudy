package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2422 {
    static int n, m, ans;
    static int[] selected;
    static boolean[][] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[n + 1];
        arr = new boolean[n + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = true;
            arr[y][x] = true;
        }
    }

    static boolean check() {
        for (int i = 1; i <= 3; i++) {
            for (int j = i + 1; j <= 3; j++) {
                if (arr[selected[i]][selected[j]]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void dfs(int k) {
        if (k == 4) {
            if (check()) {
                ans++;
            }
        } else {
            for (int i = selected[k - 1] + 1; i <= n; i++) {
                selected[k] = i;
                dfs(k + 1);
                selected[k] = 0;
            }
        }
    }

    static void solve() {
        dfs(1);

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
