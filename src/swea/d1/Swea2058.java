package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea2058 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String temp = br.readLine();
            int num = Integer.parseInt(temp);
            int sum = 0;
            for (int i = 0; i < temp.length(); i++) {
                sum += num%10;
                num/=10;
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
