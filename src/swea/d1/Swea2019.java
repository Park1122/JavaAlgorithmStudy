package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea2019 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int limit = Integer.parseInt(br.readLine());
            int start = 1;
            for (int i = 0; i < limit; i++) {
                System.out.print(start+" ");
                start *= 2;
            }
            System.out.println(start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
