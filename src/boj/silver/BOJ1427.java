package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1427 {
    static StringBuilder sb = new StringBuilder();
    static String[] strings;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strings = br.readLine().split("");
    }

    static void sort() {
        Arrays.sort(strings, Collections.reverseOrder());
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        System.out.println(sb.toString());
    }
}
