package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5597 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visit;

    static void input() throws IOException {
        visit = new boolean[31];
        for (int i = 1; i <= 28; i++) {
            int x = Integer.parseInt(br.readLine());
            visit[x] = true;
        }
    }

    static void solve() {
        for (int i = 1; i <= 30; i++) {
            if (!visit[i]) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
