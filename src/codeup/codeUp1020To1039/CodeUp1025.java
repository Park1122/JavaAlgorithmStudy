package codeup.codeUp1020To1039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int d = 10000;
        while (d >= 1) {
            int p = (num/d)*d;
            System.out.println("[" + p +"]");
            num -= p;
            d /= 10;
        }
    }
}
