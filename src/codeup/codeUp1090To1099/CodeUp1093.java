package codeup.codeUp1090To1099;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int[] arr = new int[23];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < total; i++) {
            int t = Integer.parseInt(st.nextToken());
            arr[t-1]++;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
