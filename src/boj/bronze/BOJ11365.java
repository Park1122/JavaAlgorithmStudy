package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11365 {
    static String str;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        str = br.readLine();
    }

    static void pro() {
        System.out.println(sb.append(str).reverse().toString());
        sb = new StringBuilder();
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if(str.equals("END")) break;
            pro();
        }
    }
}
