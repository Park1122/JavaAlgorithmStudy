package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20055 {
    static int n, k, step;
    static int[] a;
    static boolean[] robot;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[2 * n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2 * n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        robot = new boolean[n + 1];
    }

    // 4단계 체크
    static boolean isRun() {
        int cnt = 0;
        for (int i = 1; i <= 2 * n; i++) {
            if(a[i] == 0) cnt++;
        }

        if (cnt >= k) {
            return false;
        } else {
            return true;
        }
    }

    static void simulation() {
        while (isRun()) {
            // 1단계
            // 벨트 한칸 이동 -> 내구도 값 한칸씩 이동
            int tmp = a[2*n];
            for (int i = 2*n; i > 1 ; i--) {
                a[i] = a[i - 1];
            }
            a[1] = tmp;
            // 로봇 한칸 같이 이동
            for (int i = n; i > 1; i--) {
                robot[i] = robot[i - 1];
            }
            robot[1] = false; // 이동 후에는 첫번째 칸에 로봇이 있을 수 없음

            // 2단계 - 로봇 이동
            robot[n] = false; // 로봇 내림
            for (int i = n; i > 1; i--) {
                if (robot[i - 1] && !robot[i] && a[i] >= 1) {
                    robot[i] = true;
                    robot[i-1] = false;
                    a[i]--;
                }
            }

            // 3단계 - 로봇 올리기
            if (a[1] > 0) {
                robot[1] = true;
                a[1]--;
            }

            step++;
        }
    }

    static void solve() {
        simulation();
        System.out.println(step);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
