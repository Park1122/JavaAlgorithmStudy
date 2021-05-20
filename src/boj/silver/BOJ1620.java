package boj.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, String> numberGuide = new HashMap<>();
        Map<String, Integer> nameGuide = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            numberGuide.put(i + 1, name);
            nameGuide.put(name, i + 1);
        }

        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            if ('A' <= question.charAt(0) && question.charAt(0) <= 'Z') {
                bw.write(nameGuide.get(question) + "\n");
            } else {
                bw.write(numberGuide.get(Integer.parseInt(question)) + "\n");
            }
        }
        bw.flush();
    }
}
