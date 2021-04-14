package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea2046 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                System.out.print("#");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
