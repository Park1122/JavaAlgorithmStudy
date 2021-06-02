package boj.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1920 {
    public static void main(String[] args) throws IOException {
        // 순차 탐색 -> 시간 초과
        // 이진 탐색 -> 통과
        // Arrays.sort(), Collections.sort() -> 있을 경우 item의 index 반환, 없을 경우 음수 반환
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

        int tc = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < tc; i++) {
            if (Collections.binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }

        bw.flush();
        br.close();
    }
}
