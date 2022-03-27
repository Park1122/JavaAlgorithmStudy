package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2343 {
    static int N, M;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static boolean determine(int size) {
        int cnt = 1, sum = 0;
        for (int i = 1; i <= N; i++) {
            if (sum + A[i] > size) {
                cnt++;
                sum = A[i];
            } else {
                sum += A[i];
            }
        }

        return cnt <= M;
    }

    static void pro() {
        int L = A[1], R = 1_000_000_000, ans = 0;
        for (int i = 0; i < N; i++) {
            // 적어도 제일 긴 녹화분 만큼은 필요
            L = Math.max(L, A[i]);
        }

        // [L ~ R] 범위 내에 요구 블루레이 사이즈가 존재!
        // 이분탐색 사용하여 빠르게 답 구하기
        while (L <= R) {
            int mid = (L + R) / 2;

            if (determine(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
