package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9020 {
    static int n;
    static boolean[] primes;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    static void solve() {
        int p = n/2;
        int q = n/2;

        while (true) {
            if (!primes[p] && !primes[q]) {
                sb.append(p).append(' ').append(q).append('\n');
                break;
            }
            p--;
            q++;
        }
    }

    // 소수 체크
    static void pre() {
        // false : 소수
        primes = new boolean[10001];
        primes[0] = true;
        primes[1] = true;

        for (int i = 2; i <= Math.sqrt(primes.length); i++) {
            if(primes[i]) continue;
            for (int j = i * i; j < primes.length; j+=i) {
                primes[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        pre();
        while (t-- > 0) {
            input();
            solve();
        }
        System.out.println(sb);
    }
}
