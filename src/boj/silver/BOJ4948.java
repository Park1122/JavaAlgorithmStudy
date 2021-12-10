package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4948 {
    static boolean[] primes; // 소수들은 false
    static int[] counts;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void input() {
        primes = new boolean[246913];
        counts = new int[246913];
    }

    // 에라토스테네스의 체 이용
    static void getPrime() {
        primes[0] = true;
        primes[1] = true;

        // N = p * q
        // p나 q는 루트N보다 작거나 같음
        for (int i = 2; i <= Math.sqrt(primes.length); i++) {
            if(primes[i]) continue;
            // i의 배수들을 걸러주기 위한 반복문
            for (int j = i * i; j < primes.length; j += i) {
                primes[j] = true;
            }
        }
    }

    static void countPrime() {
        int cnt = 0;
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) {
                cnt++;
            }
            counts[i] = cnt;
        }
    }

    static void solve() throws IOException {
        getPrime();
        countPrime();

        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            if(n == 0) break;

            sb.append(counts[n * 2] - counts[n]).append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
