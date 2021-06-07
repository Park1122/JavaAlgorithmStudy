package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (n % h == 0) {
                bw.write((h * 100) + (n / h) + "\n");
            } else {
                bw.write((n % h) * 100 + ((n / h) + 1) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
