package codeup.codeUp1060To1069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        if (num >= 90) {
            System.out.println("A");
        }else if(num >= 70){
            System.out.println("B");
        }else if(num >= 40){
            System.out.println("C");
        }else{
            System.out.println("D");
        }
    }
}
