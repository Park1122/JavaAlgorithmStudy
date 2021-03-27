package codeup.codeUp1060To1069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1067 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        if (num > 0) {
            System.out.println("plus");
            if(num%2==0) System.out.println("even");
            else System.out.println("odd");
        } else {
            System.out.println("minus");
            if(num%2==0) System.out.println("even");
            else System.out.println("odd");
        }
    }
}
