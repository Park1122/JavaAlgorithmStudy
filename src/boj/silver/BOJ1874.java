package boj.silver;

import java.io.*;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int start = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > start) {
                for (int k = start + 1; k <= num; k++) {
                    stack.push(k);
                    sb.append("+").append("\n");
                }
                start = num;
            } else if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
