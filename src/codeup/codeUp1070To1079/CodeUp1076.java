package codeup.codeUp1070To1079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c = br.readLine().charAt(0);
        char a = 'a';
        for (int i = (int) a; i <= (int) c; i++) {
            System.out.print((char)i + " ");
        }
    }
}
