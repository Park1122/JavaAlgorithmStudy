package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < tc; i++) {
            String method = br.readLine();
            if (method.contains("push_front")) {
                StringTokenizer st = new StringTokenizer(method);
                String temp = st.nextToken();
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if (method.contains("push_back")) {
                StringTokenizer st = new StringTokenizer(method);
                String temp = st.nextToken();
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if (method.contains("pop_front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollFirst());
                }
            } else if (method.contains("pop_back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollLast());
                }
            } else if (method.contains("size")) {
                System.out.println(deque.size());
            } else if (method.contains("empty")) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (method.equals("front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekFirst());
                }
            }else { // back
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekLast());
                }
            }
        }
    }
}
