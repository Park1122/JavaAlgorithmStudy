package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11729 {
    static int N, ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    // n : 옮길 원판의 개수
    // start : 출발지
    // mid : 목표지로 가기 전에 거치는 곳
    // to : 목표지
    static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start).append(' ').append(to).append('\n');
            return;
        }

        // 제일 아래 제외하고 그 위에 원판들 옮기기
        hanoi(n - 1, start, to, mid);

        // 제일 아래 남은 원판 목표지로 이동
        sb.append(start).append(' ').append(to).append('\n');

        // 거치는 곳에 옮겨져 있는 원판들을 마저 목표지로 이동
        hanoi(n - 1, mid, start, to);
    }

    static void solve() {
        // 총 횟수 계산
        ans = (int)Math.pow(2, N) - 1;
        sb.append(ans).append('\n');

        // 백트래킹
        hanoi(N, 1, 2, 3);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
