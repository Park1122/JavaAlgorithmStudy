package boj.silver;

import java.io.*;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String ps = br.readLine();
            bw.write(solve(ps) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static String solve(String ps) {
        int count = 0;
        for (int k = 0; k < ps.length(); k++) {
            char c = ps.charAt(k);

            if (c == '(') {
                count++;
            } else if (count == 0) {
                return "NO";
            } else {
                count--;
            }
        }

        if (count == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
