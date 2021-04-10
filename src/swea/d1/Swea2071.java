package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea2071 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                float sum = 0;
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 10; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    sum += num;
                }
                System.out.println("#" + (i+1) + " " + Math.round((sum/10)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
