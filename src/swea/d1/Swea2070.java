package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea2070 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                System.out.print("#"+(i+1)+" ");
                if (a > b) {
                    System.out.println(">");
                } else if (a < b) {
                    System.out.println("<");
                } else {
                    System.out.println("=");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
