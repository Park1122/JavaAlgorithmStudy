package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int total = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= total; i++) {
            queue.add(i);
        }

        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < limit; i++) {
                if (i == limit - 1) {
                    sb.append(queue.poll()).append(", ");
                } else {
                    queue.add(queue.poll());
                }
            }

        }
        bw.write(sb.substring(0, sb.length()-2) + ">");
        bw.flush();

    }
}
