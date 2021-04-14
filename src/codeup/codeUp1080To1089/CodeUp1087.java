package codeup.codeUp1080To1089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limit = Integer.parseInt(br.readLine());
        int i = 0;
        int sum = 0;
        while (sum < limit) {
            i++;
            sum += i;
        }
        System.out.println(sum);
    }
}
