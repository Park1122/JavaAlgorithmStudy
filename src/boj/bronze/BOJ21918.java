package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21918 {
    static int n, m;
    static int[] bulbs;
    static int[][] commands;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        bulbs = new int[n + 1];
        commands = new int[m + 1][3];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            bulbs[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            commands[i][0] = Integer.parseInt(st.nextToken());
            commands[i][1] = Integer.parseInt(st.nextToken());
            commands[i][2] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        for (int i = 1; i <= m; i++) {
            int command = commands[i][0];
            int a = commands[i][1];
            int b = commands[i][2];

            if (command == 1) {
                bulbs[a] = b;
            } else if (command == 2) {
                for (int j = a; j <= b; j++) {
                    if (bulbs[j] == 0) {
                        bulbs[j] = 1;
                    } else {
                        bulbs[j] = 0;
                    }
                }
            } else if (command == 3) {
                for (int j = a; j <= b; j++) {
                    if(bulbs[j] == 1) bulbs[j] = 0;
                }
            } else {
                for (int j = a; j <= b; j++) {
                    if(bulbs[j] == 0) bulbs[j] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(bulbs[i]).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
