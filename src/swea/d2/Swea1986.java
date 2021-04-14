package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea1986 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCase = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCase; i++) {
                int num = Integer.parseInt(br.readLine());
                int sum = 0;
                for (int j = 1; j <= num; j++) {
                    if (j % 2 == 0) {
                        sum -= j;
                    } else {
                        sum += j;
                    }
                }
                System.out.println("#" + (i+1) + " " + sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
