package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea2056 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                String temp = br.readLine();
                String year = temp.substring(0, 4);
                String month = temp.substring(4, 6);
                String day = temp.substring(6);
                int iDay = Integer.parseInt(day);
                System.out.print("#" + (i+1) + " ");
                switch (Integer.parseInt(month)) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (0 < iDay && iDay < 32) {
                            System.out.println(year + "/" + month + "/" + day);
                        } else {
                            System.out.println(-1);
                        }
                        break;
                    case 2:
                        if (0 < iDay && iDay < 29) {
                            System.out.println(year + "/" + month + "/" + day);
                        } else {
                            System.out.println(-1);
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (0 < iDay && iDay < 31) {
                            System.out.println(year + "/" + month + "/" + day);
                        } else {
                            System.out.println(-1);
                        }
                        break;
                    default:
                        System.out.println(-1);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
