package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isAsc = false;
        boolean isDesc = false;
        boolean isMixed = false;
        int temp = 0;

        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            if (temp != 0) {
                if ((x - temp) == 1) {
                    isAsc = true;
                }
                if ((x - temp) == -1) {
                    isDesc = true;
                }
                if (Math.abs(temp - x) != 1) {
                    isMixed = true;
                    break;
                }
            }
            temp = x;
        }

        if (isMixed) {
            System.out.println("mixed");
        } else if(isAsc) {
            System.out.println("ascending");
        } else if (isDesc) {
            System.out.println("descending");
        }
    }
}
