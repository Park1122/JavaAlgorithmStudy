package codeup.codeup1020to1039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1035 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int hex = Integer.parseInt(s, 16);
        System.out.println(Integer.toOctalString(hex));
    }
}
