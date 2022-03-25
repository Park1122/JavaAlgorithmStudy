package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654 {
    static int K, N;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }

    static boolean determine(long D) {
        long sum = 0;

        for (int i = 1; i <= K; i++) {
            sum += A[i] / D;
        }

        return sum >= N;
    }

    static void pro() {
        Arrays.sort(A, 1, K + 1);

        // 덧셈시 int 범위를 넘어가기 때문에 long 타입 선언 필수
        long L = 1;
        long R = A[K];
        long ans = 0;

        while (L <= R) {
            long mid = (L + R) / 2;

            if (determine(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
