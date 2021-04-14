package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1948 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCase = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCase; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int firstMonth = Integer.parseInt(st.nextToken());
                int firstDay = Integer.parseInt(st.nextToken());
                int secondMonth = Integer.parseInt(st.nextToken());
                int secondDay = Integer.parseInt(st.nextToken());
                int result = 0;
                if (firstMonth == secondMonth) {
                    result = secondDay - firstDay + 1;
                } else {
                    result = getDay(firstMonth) - firstDay + 1;
                    int j = 1;
                    while (true) {
                        if (firstMonth + j == secondMonth) {
                            result += secondDay;
                            break;
                        }
                        result += getDay(firstMonth + j);
                        j++;
                    }
                }
                System.out.println("#" + (i+1) + " " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getDay(int month) {
        int day = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            case 2:
                day = 28;
                break;
        }
        return day;
    }
}
