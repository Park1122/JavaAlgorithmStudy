package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea1545 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int start = Integer.parseInt(br.readLine());
            for (int i = start; i >= 0; i--) {
                System.out.print(i+" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
