package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14467 {
    static int n;
    static int[][] cows;
    static int[] states;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        states = new int[11];
        cows = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[i][0] = x;
            cows[i][1] = y;
        }
    }

    static void solve() {
        for (int i = 1; i <= 10; i++) {
            states[i] = -1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cow = cows[i][0];
            int load = cows[i][1];
            if (states[cow] == -1) {
                states[cow] = load;
            } else if (states[cow] != load) {
                states[cow] = load;
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
