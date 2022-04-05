package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470ByTwoPointer {
    static int N;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        // 투 포인터 사용 전 정렬
        Arrays.sort(A, 1, N + 1);

        int bestSum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0, L = 1, R = N;

        while (L < R) { // L == R인 경우는 선택한 용액이 1개가 되는 경우이므로
            int sum = A[L] + A[R];
            if (Math.abs(sum) < bestSum) {
                bestSum = Math.abs(sum);
                v1 = A[L];
                v2 = A[R];
            }

            if(sum > 0) R--;
            else L++;
        }

        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
