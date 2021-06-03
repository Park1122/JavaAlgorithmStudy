package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        String[][] persons = new String[tc][2];
        StringTokenizer st;
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            persons[i][0] = st.nextToken();
            persons[i][1] = st.nextToken();
        }
        Arrays.sort(persons, Comparator.comparingInt(o -> Integer.parseInt(o[0])));

        for (int i = 0; i < tc; i++) {
            bw.write(persons[i][0] + " " + persons[i][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
