package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1764 {
    static int n, m;
    static HashSet<String> noListened, noWatched;
    static ArrayList<String> overlapped;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        noListened = new HashSet<>();
        noWatched = new HashSet<>();
        overlapped = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            noListened.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            noWatched.add(br.readLine());
        }
    }

    static void compare() {
        if (n >= m) {
            for (String s : noListened) {
                if (noWatched.contains(s)) {
                    overlapped.add(s);
                }
            }
        } else {
            for (String s : noWatched) {
                if (noListened.contains(s)) {
                    overlapped.add(s);
                }
            }
        }

        Collections.sort(overlapped);
        sb.append(overlapped.size()).append('\n');
        for (String s : overlapped) {
            sb.append(s).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        compare();
        System.out.println(sb.toString());
    }
}
