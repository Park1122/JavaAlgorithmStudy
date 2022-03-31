package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    static int N, M;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int R = 0; // 우측 포인터
        int sum = 0; // L ~ R 까지의 합
        int ans = 0; // 조건에 부합하는 경우의 수

        for (int L = 1; L <= N; L++) {
            sum -= A[L - 1];

            while (R + 1 <= N && sum < M) {
                R++;
                sum += A[R];
            }

            if (sum == M) ans++;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
