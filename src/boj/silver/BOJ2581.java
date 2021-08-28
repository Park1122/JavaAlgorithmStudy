package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2581 {
    static int M, N;
    static boolean[] nums;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        nums = new boolean[N + 1];
    }

    static void preprocess() {
        for (int i = M; i <= N; i++) {
            int check = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    check++;
                }
            }
            if (check == 2) {
                nums[i] = true;
            }
        }
    }

    static void solve() {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int hasCount = 0;

        for (int i = M; i <= N; i++) {
            if (nums[i]) {
                hasCount++;
                sum+=i;
                if (min > i) {
                    min = i;
                }
            }
        }

        if (hasCount == 0) {
            sb.append(-1);
        } else {
            sb.append(sum).append('\n').append(min);
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        preprocess();
        solve();
    }
}
