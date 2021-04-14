package codeup.codeUp1080To1089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1088 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        for (int i = 1; i <= l; i++) {
            if(i%3==0) continue;
            System.out.println(i);
        }
    }
}
