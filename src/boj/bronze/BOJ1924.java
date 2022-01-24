package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1924 {
    static int x, y;
    static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] dayOfWeeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        int day = y;

        for (int i = 0; i < x - 1; i++) {
            day += daysInMonth[i];
        }

        System.out.println(dayOfWeeks[day % 7]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
