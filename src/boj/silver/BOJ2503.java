package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2503 {
    static int n, ans;
    static int[][] ask;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        ask = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ask[i][0] = Integer.parseInt(st.nextToken());
            ask[i][1] = Integer.parseInt(st.nextToken());
            ask[i][2] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        for (int i = 123; i <= 987; i++) {
            // 숫자야구에서 사용 가능한 수인지 확인
            String numString = String.valueOf(i);

            // 0 사용 확인
            if (numString.contains("0")) continue;
            // 중복하여 숫자 사용했는지 확인
            if (numString.charAt(0) == numString.charAt(1)) continue;
            if (numString.charAt(1) == numString.charAt(2)) continue;
            if (numString.charAt(0) == numString.charAt(2)) continue;
            if (numString.charAt(0) == numString.charAt(1) && numString.charAt(1) == numString.charAt(2)) continue;

            int passCnt = 0;
            for (int j = 0; j < n; j++) {
                String askString = String.valueOf(ask[j][0]);
                int strike = ask[j][1];
                int ball = ask[j][2];

                int strikeCnt = 0;
                int ballCnt = 0;
                // 스트라이크 확인
                for (int k = 0; k < 3; k++) {
                    if (numString.charAt(k) == askString.charAt(k)) {
                        strikeCnt++;
                    }
                }

                // 볼 확인
                for (int k = 0; k < 3; k++) {
                    for (int t = 0; t < 3; t++) {
                        if (askString.charAt(k) == numString.charAt(t) && k != t) {
                            ballCnt++;
                        }
                    }
                }

                // 결과 비교
                if (strikeCnt == strike && ballCnt == ball) {
                    passCnt++;
                }
            }
            if (passCnt == n) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
