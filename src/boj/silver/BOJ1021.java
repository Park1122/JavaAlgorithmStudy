package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021 {
    static int n, m, count;
    static LinkedList<Integer> deq;
    static int[] numbers;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        deq = new LinkedList<>();
        numbers = new int[m];

        for (int i = 1; i <= n; i++) {
            deq.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        for (int i = 0; i < m; i++) {
            int targetIndex = deq.indexOf(numbers[i]);
            int halfLine;
            if (deq.size() % 2 == 0) {
                halfLine = deq.size() / 2 - 1;
            } else {
                halfLine = deq.size() / 2;
            }

            if (targetIndex <= halfLine) {
                for (int j = 0; j < targetIndex; j++) {
                    deq.offerLast(deq.pollFirst());
                    count++;
                }
            } else {
                for (int j = 0; j < deq.size() - targetIndex; j++) {
                    deq.offerFirst(deq.pollLast());
                    count++;
                }
            }

            deq.pollFirst();
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(count);
    }
}
