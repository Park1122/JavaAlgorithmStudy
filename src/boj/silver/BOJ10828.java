package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ10828 {
    ArrayList<Integer> stack = new ArrayList<>();

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.remove(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }

    public int empty() {
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.get(stack.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        BOJ10828 boj = new BOJ10828();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String line = br.readLine();
            if (line.contains("push")) {
                StringTokenizer st = new StringTokenizer(line);
                String temp = st.nextToken();
                boj.push(Integer.parseInt(st.nextToken()));
            } else if (line.contains("pop")) {
                System.out.println(boj.pop());
            } else if (line.contains("size")) {
                System.out.println(boj.size());
            } else if (line.contains("empty")) {
                System.out.println(boj.empty());
            } else {
                System.out.println(boj.top());
            }
        }
    }
}
