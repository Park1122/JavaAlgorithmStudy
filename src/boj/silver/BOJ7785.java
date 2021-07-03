package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ7785 {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static HashSet<String> people;
    static ArrayList<String> answers;
    static StringTokenizer st;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        people = new HashSet<>();
        answers = new ArrayList<>();
    }

    static void check() throws IOException {
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String command = st.nextToken();

            if (command.equals("enter")) {
                people.add(name);
            } else {
                people.remove(name);
            }
        }
        answers.addAll(people);
        answers.sort(Collections.reverseOrder());

        for (String answer : answers) {
            sb.append(answer).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        check();
        System.out.println(sb.toString());
    }
}
