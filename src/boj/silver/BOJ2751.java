package boj.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2751 {
    public static void main(String[] args) throws IOException {
        // Arrays.sort() -> O(nlogn) ~ O(n^2)
        // Collections.sort() -> O(n) ~ O(nlogn) : 합병정렬과 삽입정렬을 합쳐둔 Timesort

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < tc; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);

        for (Integer item : arr) {
            bw.write(item + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
