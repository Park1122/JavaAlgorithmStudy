package boj.bronze;

import java.io.*;

public class BOJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int[][] apt = new int[15][15];

        // create apt
        for (int i = 0; i < 15; i++) {
            apt[0][i] = i;
            apt[i][1] = 1;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
            }
        }

        // find
        for (int i = 0; i < tc; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(apt[k][n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
