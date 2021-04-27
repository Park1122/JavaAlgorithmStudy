package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String ch = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                for (int k = 0; k < num; k++) {
                    list.add(ch);
                }
            }
            System.out.println("#" + t);
            for (int i = 0; i < list.size(); i++) {
                if (i != 0 && i % 10 == 0) {
                    System.out.println();
                }
                System.out.print(list.get(i));
            }
            System.out.println();
        }
    }
}
