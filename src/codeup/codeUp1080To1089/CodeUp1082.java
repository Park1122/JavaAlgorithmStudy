package codeup.codeUp1080To1089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String hex = br.readLine();
        int hexNum = Integer.parseInt(hex, 16);
        for (int i = 1; i < 16; i++) {
            int v = hexNum * i;
            System.out.println(hex+"*"+Integer.toHexString(i).toUpperCase()+"="+Integer.toHexString(v).toUpperCase());
        }
    }
}
