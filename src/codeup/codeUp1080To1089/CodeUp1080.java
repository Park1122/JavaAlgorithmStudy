package codeup.codeUp1080To1089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limit = Integer.parseInt(br.readLine());
        int sum = 0;
        int num = 1;
        while (true) {
            sum += num;
            if (sum >= limit) {
                System.out.println(num);
                break;
            }
            num++;
        }
    }
}
