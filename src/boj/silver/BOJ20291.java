package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ20291 {
    static int n;
    static String[] files;
    static HashMap<String, Integer> map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        files = new String[n];
        for (int i = 0; i < n; i++) {
            files[i] = br.readLine();
        }
        map = new HashMap<>();
    }

    static void solve() {
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(files[i], ".");
            st.nextToken();
            String ext = st.nextToken();
            if (map.containsKey(ext)) {
                map.put(ext, map.get(ext) + 1);
            } else {
                map.put(ext, 1);
            }
        }

        ArrayList<String> temp = new ArrayList<>();
        for (String ext : map.keySet()) {
            temp.add(ext);
        }
        Collections.sort(temp);

        // 출력
        for (String ext : temp) {
            sb.append(ext).append(' ').append(map.get(ext));
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
