package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    static int N, C;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }

    static boolean determine(int D) {
        // D 만큼의 거리 차이를 둔다면 C개 만큼의 공유기 설치가 가능한가?

        // 제일 왼쪽 집부터 설치
        // D 만큼의 거리를 두면서 최대로 설치한 개수와 C 비교
        int cnt = 1;
        int last = A[1];
        for (int i = 2; i <= N; i++) {
            // 이번에 A[i] 설치가 가능한가?
            if (A[i] - last >= D) {
                cnt++;
                last = A[i];
            }
        }
        return cnt >= C;
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);

        int L = 1;
        int R = 1_000_000_000;
        int ans = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
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
