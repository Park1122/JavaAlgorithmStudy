package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ5430 {
    static int T, N;
    static String P;
    static Deque<Integer> deq;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        P = br.readLine();
        N = Integer.parseInt(br.readLine());
        String array = br.readLine();
        StringTokenizer st = new StringTokenizer(array.substring(1, array.length() - 1), ",");
        deq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deq.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void solve() {
        int rCount = 0;
        boolean isError = false;
        for (int i = 0; i < P.length(); i++) {
            if (P.charAt(i) == 'R') {
                rCount++;
            } else {
                if (deq.isEmpty()) {
                    isError = true;
                    sb.append("error").append('\n');
                    break;
                }

                if (rCount % 2 == 0) {
                    deq.pollFirst();
                } else {
                    deq.pollLast();
                }
            }
        }
        if (!isError) {
            printArray(rCount);
        }
    }

    static void printArray(int rCount) {
        sb.append('[');
        if (!deq.isEmpty()) {
            if (rCount % 2 == 0) {
                sb.append(deq.pollFirst());
                while (!deq.isEmpty()) {
                    sb.append(',').append(deq.pollFirst());
                }
            } else {
                sb.append(deq.pollLast());
                while (!deq.isEmpty()) {
                    sb.append(',').append(deq.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            input();
            solve();
        }
        System.out.println(sb);
    }
}
