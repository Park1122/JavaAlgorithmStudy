package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927 {
    static int n;
    static PriorityQueue<Integer> pq;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

    }

    static void operate() throws IOException {
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(remove()).append('\n');
            } else {
                pq.add(num);
            }
        }
    }

    static int remove() {
        if (pq.isEmpty()) {
            return 0;
        } else {
            return pq.poll();
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        operate();
        System.out.println(sb.toString());
    }
}
