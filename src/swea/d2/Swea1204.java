package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1204 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int tc = Integer.parseInt(br.readLine());
            for (int t = 1; t <= tc; t++) {
                String temp = br.readLine();
                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] scores = new int[101];
                for (int i = 0; i < 1000; i++) {
                    int num = Integer.parseInt(st.nextToken());
                    scores[num]++;
                }
                int ans = 0;
                int max = 0;
                for (int i = 0; i < 101; i++) {
                    if (max <= scores[i]) {
                        max = scores[i];
                        ans = i;
                    }
                }
                System.out.println("#" + t + " " + ans);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
