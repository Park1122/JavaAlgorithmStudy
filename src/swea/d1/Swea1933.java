package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea1933 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(br.readLine());
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    System.out.print(i+" ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
