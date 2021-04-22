package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1976 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int tc = Integer.parseInt(br.readLine());
            for (int t = 1; t <= tc; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int firstHour = Integer.parseInt(st.nextToken());
                int firstMinute = Integer.parseInt(st.nextToken());
                int secondHour = Integer.parseInt(st.nextToken());
                int secondMinute = Integer.parseInt(st.nextToken());

                int resultHour = firstHour + secondHour + (firstMinute + secondMinute) / 60;
                while (resultHour > 12) {
                    resultHour -= 12;
                }
                int resultMinute = (firstMinute + secondMinute) % 60;
                System.out.println("#" + t + " " + resultHour + " " + resultMinute);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
