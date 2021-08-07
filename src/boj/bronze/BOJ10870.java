package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10870 {
    static int n;
    static int[] Dp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    static void solve() {
        Dp = new int[21];

        Dp[0] = 0;
        Dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            Dp[i] = Dp[i - 1] + Dp[i - 2];
        }
        System.out.println(Dp[n]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
