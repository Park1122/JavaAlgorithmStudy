package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11728 {
    static int N, M;
    static int[] A, B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        B = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        // A, B 배열 모두 하나씩 원소 비교
        // 시작 인덱스는 1
        int L = 1, R = 1;

        // A, B 둘다 끝이 아닌 경우
        while (L <= N && R <= M) {
            if (A[L] >= B[R]) {
                sb.append(B[R]).append(' ');
                R++;
            } else {
                sb.append(A[L]).append(' ');
                L++;
            }
        }

        // 둘 중 하나가 끝인 경우
        while (L <= N) {
            sb.append(A[L]).append(' ');
            L++;
        }
        while (R <= M) {
            sb.append(B[R]).append(' ');
            R++;
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
