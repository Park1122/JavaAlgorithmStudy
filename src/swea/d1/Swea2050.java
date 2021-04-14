package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea2050 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) { // 'A' : 65 ~ 'Z' : 90
                System.out.print((int)(str.charAt(i)) - 64);
                System.out.print(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
