package boj.bronze;

import java.io.*;

public class BOJ15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int r = 31;
        int m = 1234567891;

        long answer = 0;
        for (int i = 0; i < length; i++) {
            long num = line.charAt(i) - 'a' + 1;
            for (int k = 0; k < i; k++) {
                num *= r;
                num %= m;
            }
            answer += num;
            answer %= m;
        }
        bw.write(answer+ "");
        bw.flush();
        bw.close();
        br.close();
    }
}
