package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1936 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 1: 가위, 2: 바위, 3: 보 // 3<1, 1<2, 2<3
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                if (b == 2) {
                    System.out.println("B");
                } else if (b == 3) {
                    System.out.println("A");
                }
            } else if (a == 2) {
                if (b == 1) {
                    System.out.println("A");
                } else if (b == 3) {
                    System.out.println("B");
                }
            } else if (a == 3) {
                if (b == 1) {
                    System.out.println("B");
                } else if (b == 2) {
                    System.out.println("A");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
