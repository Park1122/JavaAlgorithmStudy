package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int top = 1;
        for (int i = 1; i <= n; i++) {
            top *= i;
        }
        int down = 1;
        for (int i = 1; i <= r; i++) {
            down *= i;
        }
        for (int i = 1; i <= (n - r); i++) {
            down *= i;
        }

        bw.write((top/down) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
