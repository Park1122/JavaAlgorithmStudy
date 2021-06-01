package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int count = 0;

        while (true) {
            if (total % 5 == 0) {
                count += total / 5;
                System.out.println(count);
                break;
            } else {
                total -= 3;
                count++;
            }

            if (total < 0) {
                System.out.println(-1);
                break;
            }
        }
    }
}
