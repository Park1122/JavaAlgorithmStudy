package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286 {
    static int N;
    static PriorityQueue<Integer> pq;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void solve(int x) {
        if (x == 0) {
            if (pq.isEmpty()) {
                sb.append(0);
            } else {
                sb.append(pq.poll());
            }
            sb.append('\n');
        } else {
            pq.add(x);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 == abs2) {
                return o1 - o2;
            } else {
                return abs1 - abs2;
            }
        });

        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(br.readLine());
            solve(x);
        }
        System.out.println(sb);
    }
}
