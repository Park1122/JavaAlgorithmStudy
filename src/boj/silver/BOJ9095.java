package boj.silver;

import java.io.*;

public class BOJ9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int[] arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i <= 10; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(arr[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
