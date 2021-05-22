package boj.silver;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        Set<String> stringSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            stringSet.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            if (stringSet.contains(br.readLine())) {
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
    }
}
