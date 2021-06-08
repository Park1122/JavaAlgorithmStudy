package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        int max = 1;
        int temp = 0;
        //max
        while (temp <= Math.min(a, b)) {
            temp++;
            if (a % temp == 0 && b % temp == 0) {
                max = temp;
            }
        }

        //min
        int min = Math.max(a, b);
        while (true) {
            if (min % a == 0 && min % b == 0) {
                break;
            }
            min++;
        }

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
        br.close();
    }
}
