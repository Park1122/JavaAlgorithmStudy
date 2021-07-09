package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
    static StringBuilder sb = new StringBuilder();
    static int[] nums, selected;
    static int n;
    static int m = 6;

    static void recFunc(int k) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(nums[selected[i]]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int cand = selected[k - 1] + 1; cand <= n; cand++) {
                selected[k] = cand;
                recFunc(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(str);
            n = Integer.parseInt(st.nextToken());
            nums = new int[n + 1];
            selected = new int[m + 1];
            for (int i = 1; i <= n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            recFunc(1);
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
