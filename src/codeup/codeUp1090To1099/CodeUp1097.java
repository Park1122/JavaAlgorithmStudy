package codeup.codeUp1090To1099;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1097 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arrs = new int[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arrs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = Integer.parseInt(br.readLine());
        for (int k = 0; k < count; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int t = 0; t < 19; t++) {
                if (t == (x - 1) && t == (y - 1)) {
                    continue;
                }
                if(arrs[x-1][t] == 0) arrs[x-1][t] = 1;
                else arrs[x-1][t] = 0;
            }
            for (int t = 0; t < 19; t++) {
                if (t == (x - 1) && t == (y - 1)) {
                    continue;
                }
                if(arrs[t][y-1] == 0) arrs[t][y-1] = 1;
                else arrs[t][y-1] = 0;
            }
        }
        for (int[] arr : arrs) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
