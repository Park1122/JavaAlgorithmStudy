package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10988 {
    static String str;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        str = br.readLine();
    }

    static void solve() {
        boolean flag = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? 1 : 0);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
