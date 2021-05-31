package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int count = tc;

        for (int i = 0; i < tc; i++) {
            Set<Character> wordSet = new HashSet<>();
            String word = br.readLine();
            char[] wordArr = word.toCharArray();
            for (char c : wordArr) {
                wordSet.add(c);
            }

            for (int k = 0; k < word.length(); k++) {
                if (k>0 && wordArr[k - 1] != wordArr[k]) {
                    wordSet.remove(wordArr[k - 1]);
                }
                if (wordSet.contains(wordArr[k])) {
                    continue;
                } else {
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
