package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }
        
        int count = 1;
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                break;
            }
            if (count % 2 != 0) {
                queue.poll();
            } else {
                queue.add(queue.poll());
            }
            count++;
        }

        System.out.println(queue.peek());
    }
}
