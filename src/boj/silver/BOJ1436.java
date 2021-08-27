package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1436 {
    static int N;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    static void solve() {
        int cnt = 0;
        int num = 666;
        while (true) {
            if (String.valueOf(num).contains("666")) {
                cnt++;
            }
            if (cnt == N) {
                break;
            }
            num++;
        }

        System.out.println(num);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
