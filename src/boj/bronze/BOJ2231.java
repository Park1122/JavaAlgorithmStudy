package boj.bronze;

import java.io.*;

public class BOJ2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < n; i++) {
            int number = i;
            int sum = 0;

            while (number != 0) {
                sum += number%10;
                number/=10;
            }
            if ((sum + i) == n) {
                result = i;
                break;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
