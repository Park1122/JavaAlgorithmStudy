package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15989 {
    static int[][] Dy;
    static StringBuilder sb = new StringBuilder();

    static void preprocess() {
        Dy = new int[10001][4];

        Dy[1][1] = 1; // 1
        Dy[2][1] = 1; // 1+1
        Dy[2][2] = 1; // 2
        Dy[3][1] = 1; // 1+1+1
        Dy[3][2] = 1; // 1+2
        Dy[3][3] = 1; // 3
        for (int i = 4; i <= 10000; i++) {
            Dy[i][1] = Dy[i - 1][1];
            Dy[i][2] = Dy[i - 2][1] + Dy[i - 2][2];
            Dy[i][3] = Dy[i - 3][1] + Dy[i - 3][2] + Dy[i - 3][3];
        }
    }

    static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(Dy[N][1] + Dy[N][2] + Dy[N][3]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        preprocess();
        solve();
    }
}
