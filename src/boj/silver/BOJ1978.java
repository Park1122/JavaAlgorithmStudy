package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < tc; i++) {
            int check = 0;
            int num = Integer.parseInt(st.nextToken());

            for (int k = 1; k <= num; k++) {
                if (num % k == 0) {
                    check++;
                }
            }

            if (check == 2) {
                count++;
            }
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
