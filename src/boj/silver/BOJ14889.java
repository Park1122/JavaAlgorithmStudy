package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int n, min;
    static int[][] s;
    static boolean[] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        visit = new boolean[n];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // 전력 차이 계산
    static void diff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] && visit[j]) { // 스타트 팀인 경우
                    start += s[i][j];
                    start += s[j][i];
                } else if (!visit[i] && !visit[j]) { // 링크 팀인 경우
                    link += s[i][j];
                    link += s[j][i];
                }
            }
        }

        int dif = Math.abs(start - link);
        if (dif == 0) {
            // 전력 차이가 0인 경우는 더 이상 계산할 필요가 없음
            System.out.println(0);
            System.exit(0);
        } else {
            min = Math.min(min, dif);
        }
    }

    // 팀 뽑기(조합)
    static void recFunc(int idx, int cnt) {
        if (cnt == n / 2) {
            diff();
            return;
        } else {
            for (int i = idx; i < n; i++) {
                if(visit[i]) continue;
                visit[i] = true;
                recFunc(i + 1, cnt + 1);
                visit[i] = false;
            }
        }
    }

    static void solve() {
        recFunc(0, 0);
        System.out.println(min);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
