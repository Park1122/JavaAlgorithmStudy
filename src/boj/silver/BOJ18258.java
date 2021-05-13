package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ18258 {

    public static void main(String[] args) throws IOException {
        LinkedList<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String line = br.readLine();
            if (line.contains("push")) {
                StringTokenizer st = new StringTokenizer(line);
                String temp = st.nextToken();
                queue.offer(Integer.parseInt(st.nextToken()));
            } else if (line.contains("pop")) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.pop() + "\n");
                }
            } else if (line.contains("size")) {
                bw.write(queue.size() + "\n");
            } else if (line.contains("empty")) {
                if (queue.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if (line.contains(("front"))) {
                if (!queue.isEmpty()) {
                    bw.write(queue.peek() + "\n");
                } else {
                    bw.write(-1 + "\n");
                }
            } else {
                if (!queue.isEmpty()) {
                    bw.write(queue.peekLast() + "\n");
                } else {
                    bw.write(-1 + "\n");
                }
            }
        }
        bw.flush();
    }
}
