package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Swea1984 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int tc = Integer.parseInt(br.readLine());
            for (int t = 1; t <= tc; t++) {
                int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
                int sum = 0;
                for (int i = 1; i <= 8; i++) {
                    sum+=arr[i];
                }
                long avg = Math.round(sum / (double) 8);
                System.out.println("#" + t + " " + avg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
