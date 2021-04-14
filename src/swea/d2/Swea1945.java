package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea1945 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int limit = Integer.parseInt(br.readLine());
            for (int i = 0; i < limit; i++) {
                int num = Integer.parseInt(br.readLine()); // 2^a * 3^b * 5^c * 7^d * 11^e
                int a = 0;
                int b = 0;
                int c = 0;
                int d = 0;
                int e = 0;
                while (num % 2 == 0) {
                    num/=2;
                    a++;
                }
                while (num % 3 == 0) {
                    num/=3;
                    b++;
                }
                while (num % 5 == 0) {
                    num/=5;
                    c++;
                }
                while (num % 7 == 0) {
                    num/=7;
                    d++;
                }
                while (num % 11 == 0) {
                    num/=11;
                    e++;
                }
                System.out.println("#" + (i+1) + " " + a + " " + b + " " + c + " " + d + " " + e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
