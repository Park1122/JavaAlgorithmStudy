package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1284 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCase = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCase; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int aCost = w * p;
                int bCost = 0;
                if (r > w) {
                    bCost = q;
                } else {
                    bCost = q + ((w - r) * s);
                }
                if (aCost > bCost) {
                    System.out.println("#" + (i + 1) + " " + bCost);
                } else {
                    System.out.println("#" + (i + 1) + " " + aCost);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
