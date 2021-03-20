package codeup.codeup1020to1039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] list = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            list[i] = s.charAt(i);
        }
        for (char c : list) {
            System.out.println("'" + c + "'");
        }
    }
}
