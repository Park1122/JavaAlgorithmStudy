package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13144 {
    static int N;
    static int[] A, cnt;
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
        cnt = new int[100000 + 1];
    }

    static void pro() {
        long ans = 0;
        for (int L = 1, R = 0; L <= N; L++) {
            // R을 옮길 수 있는 만큼 이동
            while (R < N && cnt[A[R + 1]] == 0) {
                R++;
                cnt[A[R]]++;
            }

            // 정답 갱신
            ans += R - L + 1;

            // L을 옮겨, A[L] 개수 감소
            cnt[A[L]]--;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
