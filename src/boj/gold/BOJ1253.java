package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 '두 용액' 문제를 응용해서 풀이
 */
public class BOJ1253 {
    static int N;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    // targetIdx번째 원소가 두 수의 합으로 표현되는가?
    static boolean func(int targetIdx) {
        int L = 1, R = N, target = A[targetIdx];

        while (L < R) {
            if(L == targetIdx) L++;
            else if(R == targetIdx) R--;
            else {
                if(A[L] + A[R] == target) return true;
                if(A[L] + A[R] > target) R--;
                else L++;
            }
        }

        return false;
    }

    static void pro() {
        // 최소, 최대를 빠르게 알기 위해 정렬
        Arrays.sort(A, 1, N + 1);

        int ans = 0;
        // 타겟 원소 값이 되는가?
        for (int i = 1; i <= N; i++) {
            if(func(i)) ans++;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
