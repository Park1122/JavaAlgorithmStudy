package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int[][] people = new int[tc][2];
        StringTokenizer st;

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken()); // weight
            people[i][1] = Integer.parseInt(st.nextToken()); // height
        }

        for (int i = 0; i < tc; i++) {
            int rank = 1;

            for (int j = 0; j < tc; j++) {
                if(i == j) continue;
                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    rank++;
                }
            }
            bw.write(rank + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
