package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2075 {
    static int N;
    static PriorityQueue<Integer> pq;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    static void solve() {
        int item = 0;
        for (int i = 1; i <= N; i++) {
            item = pq.poll();
        }
        System.out.println(item);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
