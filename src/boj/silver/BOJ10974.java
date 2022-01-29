package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10974 {
    static int n;
    static int[] selected, used;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        selected = new int[n + 1];
        used = new int[n + 1];
    }

    static void recFunc(int k) {
        if (k == n + 1) {
            for (int i = 1; i <= n; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= n; i++) {
                if(used[i] == 1) continue;

                selected[k] = i;
                used[i] = 1;
                recFunc(k + 1);
                selected[k] = 0;
                used[i] = 0;
            }
        }
    }

    static void solve() {
        recFunc(1);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
