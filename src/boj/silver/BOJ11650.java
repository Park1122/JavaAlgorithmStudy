package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int[][] points = new int[tc][2];
        StringTokenizer st;

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < tc; i++) {
            bw.write(points[i][0] + " " + points[i][1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
