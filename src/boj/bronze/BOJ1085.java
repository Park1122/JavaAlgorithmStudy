package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int width = Math.min(x, (w - x));
        int height = Math.min(y, (h - y));

        bw.write(Math.min(width, height) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
