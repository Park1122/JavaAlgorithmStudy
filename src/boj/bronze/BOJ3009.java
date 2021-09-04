package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3009 {
    static int[] a, b, c, d;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        st = new StringTokenizer(br.readLine());
        b = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        st = new StringTokenizer(br.readLine());
        c = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        d = new int[2];
    }

    static void solve() {
        //check x
        if (a[0] == b[0]) {
            d[0] = c[0];
        } else if (a[0] == c[0]) {
            d[0] = b[0];
        } else {
            d[0] = a[0];
        }

        //check y
        if (a[1] == b[1]) {
            d[1] = c[1];
        } else if (a[1] == c[1]) {
            d[1] = b[1];
        } else {
            d[1] = a[1];
        }

        System.out.println(d[0] + " " + d[1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
