package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ18108 {
    static int a;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        a = Integer.parseInt(br.readLine());
    }

    static void solve() {
        System.out.println(a - 543);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
