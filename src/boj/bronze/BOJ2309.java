package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309 {
    static int[] heights, selected;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        heights = new int[10];
        for (int i = 1; i <= 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        selected = new int[10];
    }

    static void recFunc(int k) {
        if (k == 8) {
            int sum = 0;
            for (int i = 1; i <= 7; i++) {
                sum += heights[selected[i]];
            }
            if (sum == 100) {
                int[] temp = new int[8];
                for (int i = 1; i <= 7; i++) {
                    temp[i] = heights[selected[i]];
                }
                Arrays.sort(temp, 1, 8);
                for (int i = 1; i <= 7; i++) {
                    sb.append(temp[i]).append('\n');
                }
                System.out.println(sb);
                System.exit(0);
            }
        } else {
            for (int i = selected[k-1] + 1; i <= 9; i++) {
                selected[k] = i;
                recFunc(k + 1);
                selected[k] = 0;
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
