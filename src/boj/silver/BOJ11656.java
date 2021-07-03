package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ11656 {
    static String line;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> answers;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        answers = new ArrayList<>();
    }

    static void getPrefix() {
        for (int i = 0; i < line.length(); i++) {
            answers.add(line.substring(i));
        }

        Collections.sort(answers);
        for (String answer : answers) {
            sb.append(answer).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        getPrefix();
        System.out.println(sb.toString());
    }
}
