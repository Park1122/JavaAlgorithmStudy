package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

public class Swea1928 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int limit = Integer.parseInt(br.readLine());
            for (int i = 0; i < limit; i++) {
                String encoded = br.readLine();
                String decoded = new String(Base64.getDecoder().decode(encoded));
                System.out.println("#" + (i+1) + " " + decoded);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
