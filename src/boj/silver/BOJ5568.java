package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ5568 {
    static int n, k;
    static int[] nums, selected;
    static boolean[] visit;
    static HashSet<Integer> set;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        selected = new int[k + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        set = new HashSet<>();
    }

    static void dfs(int idx) {
        if (idx == k + 1) {
            sb = new StringBuilder();
            for (int i = 1; i <= k; i++) {
                sb.append(nums[selected[i]]);
            }
            set.add(Integer.parseInt(sb.toString()));
        } else {
            for (int i = 1; i <= n; i++) {
                if(visit[i]) continue;

                selected[idx] = i;
                visit[i] = true;
                dfs(idx + 1);
                selected[idx] = 0;
                visit[i] = false;
            }
        }
    }

    static void solve() {
        dfs(1);

        System.out.println(set.size());
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
