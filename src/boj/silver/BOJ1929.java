package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1929 {
    static int M, N;
    static StringBuilder sb = new StringBuilder();
    static boolean[] primes;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        primes = new boolean[N + 1];
    }

    static void getPrime() {
        primes[1] = true;

        for (int i = 2; i <= N; i++) {
            for (int j = 2; i * j <= N; j++) {
                primes[i*j] = true;
            }
        }
    }

    static void solve() {
        getPrime();

        for (int i = M; i <= N; i++) {
            if (!primes[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
