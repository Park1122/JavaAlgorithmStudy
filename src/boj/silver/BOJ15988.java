package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15988 {
    static long[] Dy;
    static StringBuilder sb = new StringBuilder();

    static void preprocess() {
        Dy = new long[1000001];

        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;
        for (int i = 4; i <= 1000000; i++) {
            Dy[i] = (Dy[i - 1] + Dy[i - 2] + Dy[i - 3]) % 1000000009;
        }
    }

    static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(Dy[N]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        preprocess();
        solve();
    }
}
