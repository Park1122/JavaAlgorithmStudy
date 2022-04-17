package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3029 {
    static String nowTime, bombTime;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        nowTime = br.readLine();
        bombTime = br.readLine();
    }

    static void pro() {
        st = new StringTokenizer(nowTime, ":");
        int h1 = Integer.parseInt(st.nextToken()), m1 = Integer.parseInt(st.nextToken())
                , s1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bombTime, ":");
        int h2 = Integer.parseInt(st.nextToken()), m2 = Integer.parseInt(st.nextToken())
                , s2 = Integer.parseInt(st.nextToken());

        int hour = h2 - h1;
        int minute = m2 - m1;
        int second = s2 - s1;

        if (second < 0) {
            second += 60;
            minute--;
        }
        if (minute < 0) {
            minute += 60;
            hour--;
        }
        if (hour < 0) {
            hour += 24;
        }

        if (hour == 0 && minute == 0 && second == 0) {
            System.out.println("24:00:00");
        } else {
            System.out.printf("%02d:%02d:%02d", hour, minute, second);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
