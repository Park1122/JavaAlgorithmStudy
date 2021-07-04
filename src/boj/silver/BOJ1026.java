package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1026 {
    static Integer[] A, B;
    static int n, sum;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new Integer[n];
        B = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void sort() {
        Arrays.sort(B);
        Arrays.sort(A, Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            sum += (A[i] * B[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        System.out.println(sum);
    }
}
