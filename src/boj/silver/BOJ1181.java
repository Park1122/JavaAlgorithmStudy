package boj.silver;

import java.io.*;
import java.util.Arrays;

public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        String[] words = new String[tc];

        for (int i = 0; i < tc; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                return o1.compareTo(o2);
            }
        });

        bw.write(words[0] + "\n");
        for (int i = 1; i < tc; i++) {
            if (!words[i].equals(words[i - 1])) {
                bw.write(words[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
