package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea2068 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] arr = new int[10];
                for (int j = 0; j < 10; j++) {
                    arr[j] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(arr);
                System.out.print("#" + (i+1) + " ");
                System.out.println(arr[9]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
