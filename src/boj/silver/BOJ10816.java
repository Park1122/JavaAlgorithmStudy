package boj.silver;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> cardMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            cardMap.putIfAbsent(num, 0);
            cardMap.replace(num, cardMap.get(num) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (cardMap.containsKey(key)) {
                bw.write(cardMap.get(key) + " ");
            } else {
                bw.write("0 ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
