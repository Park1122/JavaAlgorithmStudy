package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1300 {
    static int N, K;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
    }

    static boolean determine(long n) {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Math.min(N, n / i);
        }
        return sum >= K;
    }

    static void pro() {
        long L = 1, R = (long) N * N, ans = 0;

        while(L <= R) {
            long mid = (L + R) / 2;

            if (determine(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
