package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < k; i++) {
                if (i == k - 1) {
                    sb.append(queue.poll()).append(", ");
                } else {
                    queue.add(queue.poll());
                }
            }
        }
        String answer = sb.substring(0, sb.length() - 2) + ">";
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
