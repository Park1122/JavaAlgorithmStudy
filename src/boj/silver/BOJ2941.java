package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String question = br.readLine();
        for (String word : words) {
            question = question.replace(word, " ");
        }
        System.out.println(question.length());
    }
}
