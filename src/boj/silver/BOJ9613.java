package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9613 {
    static int N;
    static long ans;
    static int[] nums;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
    }

    static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    static void solve() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                ans += gcd(nums[i], nums[j]);
            }
        }
        sb.append(ans).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            input();
            solve();
        }
        System.out.println(sb);
    }
}
