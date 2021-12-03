package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1212 {
    static String num;
    static String[] binaryArr = {"000", "001", "010", "011", "100", "101", "110", "111"};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        num = br.readLine();
    }

    static void solve() {
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if (i == 0 && n < 4) { // 맨 앞에 000, 001, 010, 011이 오는 경우 체크
                if (n < 2) { // 000, 001인 경우
                    sb.append(binaryArr[n].substring(2));
                } else { // 010, 011인 경우
                    sb.append(binaryArr[n].substring(1));
                }
            } else {
                sb.append(binaryArr[n]);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
