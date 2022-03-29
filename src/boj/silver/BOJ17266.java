package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17266 {
    static int N, M;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        A = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static boolean determine(int h) {
        int last = 0; // 마지막으로 밝혀진 위치
        for (int i = 1; i <= M; i++) {
            if (A[i] - last <= h) {
                last = A[i] + h;
            } else {
                return false;
            }
        }
        return last >= N;
    }

    static void pro() {
        int L = 0, R = N, ans = 0;

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
