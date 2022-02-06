package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10798 {
    static String[] a;
    static int[] sizes;
    static int max;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        a = new String[5];
        sizes = new int[5];
        max = 0;
        for (int i = 0; i < 5; i++) {
            a[i] = br.readLine();
            sizes[i] = a[i].length();
            max = Math.max(sizes[i], max);
        }
    }

    static void solve() {
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                int size = sizes[j];
                if(i >= size) continue;
                sb.append(a[j].charAt(i));
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
