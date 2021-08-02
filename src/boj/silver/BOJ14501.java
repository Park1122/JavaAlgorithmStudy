package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    static int N, ans;
    static int[][] TP;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        TP = new int[N + 1][2];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            TP[i][0] = Integer.parseInt(st.nextToken());
            TP[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void recFunc(int index, int sum) {
        if (index == N + 1) {
            ans = Math.max(ans, sum);
        } else {
            if (index > N) {
                return;
            }
            for (int i = index; i <= N; i++) {
                recFunc(i + TP[index][0], sum + TP[index][1]);
                recFunc(i + 1, sum);
            }
        }
    }

    static void solve() {
        recFunc(1, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
