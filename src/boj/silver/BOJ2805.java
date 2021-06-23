package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
        int result = 0;
        int start = 0;
        int end = trees[n - 1];

        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < n; i++) {
                if (trees[i] > mid) {
                    total += trees[i] - mid;
                }
            }

            if (total < m) {
                end = mid-1;
            } else {
                start = mid+1;
                result = mid;
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
