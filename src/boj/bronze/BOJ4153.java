package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (((a * a) + (b * b)) == (c * c)) {
                bw.write("right\n");
            } else if (((a * a) + (c * c)) == (b * b)) {
                bw.write("right\n");
            } else if (((b * b) + (c * c)) == (a * a)) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
