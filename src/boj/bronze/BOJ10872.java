package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10872 {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int fac(int k) {
        if (k <= 1) {
            return 1;
        }
        return k * fac(k - 1);
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int ans = fac(N);
        System.out.println(ans);
    }
}
