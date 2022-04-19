package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16171 {
    static String str1, str2;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        str1 = br.readLine();
        str2 = br.readLine();
    }

    static void pro() {
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if ('0' <= c && c <= '9') continue;
            sb.append(c);
        }

        String newStr = sb.toString();
        if (newStr.contains(str2)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
