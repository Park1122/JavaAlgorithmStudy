package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3053 {
    static int R;
    static double uArea, tArea;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        R = Integer.parseInt(br.readLine());
    }

    static void solve() {
        // 유클리드 원의 넓이
        uArea = R * R * Math.PI;

        // 택시 기하학 원의 넓이
        tArea = R * R * 2;

        // 출력
        System.out.printf("%.6f\n", uArea);
        System.out.printf("%.6f", tArea);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
