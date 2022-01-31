package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18511 {
    static int n, k, ans;
    static int[] nums;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[k + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= k; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        ans = Integer.MIN_VALUE;
        Arrays.sort(nums, 1, k + 1);
    }

    static void dfs(int now) {
        if(now > n) return;
        if(ans < now) ans = now;

        for (int i = k; i >= 1; i--) {
            dfs(now * 10 + nums[i]);
        }
    }

    static void solve() {
        dfs(0);

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
