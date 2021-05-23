package boj.silver;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2346 {
    public static void main(String[] args) throws IOException {
        // Deque 사용시, LinkedList를 이용하는 것보다는 ArrayDeque를 이용하는 것이 메모리를 덜 먹는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 1; i <= total; i++) {
            queue.offer(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        while (!queue.isEmpty()) {
            bw.write(queue.peekFirst()[0] + " ");
            int item = queue.pollFirst()[1];
            if(queue.isEmpty()) break;

            if (item > 0) {
                for (int i = 0; i < item-1; i++) {
                    queue.offerLast(queue.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(item); i++) {
                    queue.offerFirst(queue.pollLast());
                }
            }
        }
        bw.flush();
    }
}
