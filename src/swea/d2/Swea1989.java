package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Swea1989 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCase = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCase; i++) {
                String str = br.readLine();
                char[] chars = str.toCharArray();
                char[] reverseChars = new char[chars.length];
                for (int j = chars.length - 1; j >= 0; j--) {
                    reverseChars[chars.length - j - 1] = chars[j];
                }
                if (Arrays.equals(chars, reverseChars)) {
                    System.out.println("#" + (i+1) + " " + 1);
                } else {
                    System.out.println("#" + (i+1) + " " + 0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
