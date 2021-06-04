package boj.bronze;

import java.io.*;

public class BOJ1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String question = br.readLine();
            String ans = "yes";
            if (question.equals("0")) {
                break;
            }
            for (int i = 0, l = question.length(); i < l/2; i++) {
                if (question.charAt(i) != question.charAt(l - 1 - i)) {
                    ans = "no";
                    break;
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
