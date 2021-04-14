package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Swea1959 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCase = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCase; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int[] a = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] b = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int difference = 0;
                int max = 0;
                while (true) {
                    int sum = 0;
                    if (n < m) {
                        for (int j = 0; j < n; j++) {
                            sum += a[j] * b[j + difference];
                        }
                    } else {
                        for (int j = 0; j < m; j++) {
                            sum += b[j] * a[j + difference];
                        }
                    }
                    if (sum > max) {
                        max = sum;
                    }
                    if (n < m) {
                        if((difference+n-1) == (m-1)) break;
                    } else {
                        if((difference+m-1) == (n-1)) break;
                    }
                    difference++;
                }
                System.out.println("#" + (i + 1) + " " + max);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
