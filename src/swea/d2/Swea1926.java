package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea1926 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= n; i++) {
                String strNum = Integer.toString(i);
                int num = Integer.parseInt(strNum);
                if (strNum.contains("3") || strNum.contains("6") || strNum.contains("9")) {
                    for (int j = 0; j < strNum.length(); j++) {
                        int one = num % 10;
                        if (one == 3 || one == 6 || one == 9) {
                            System.out.print("-");
                        }
                        num /= 10;
                    }
                }else{
                    System.out.print(i);
                }
                System.out.print(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
