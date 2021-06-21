package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < tc; i++) {
            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                queue.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int count = 0;
            while (!queue.isEmpty()) {
                boolean isMaxed = true;
                int[] item = queue.poll();
                int priority = item[1];
                for (int k = 0; k < queue.size(); k++) {
                    if (queue.get(k)[1] > priority) {
                        queue.offer(item);
                        isMaxed = false;
                        break;
                    }
                }
                if (isMaxed) {
                    count++;
                    if (item[0] == m) {
                        bw.write(count + "\n");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
