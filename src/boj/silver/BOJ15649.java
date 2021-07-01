package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected, used;

    public static void main(String[] args) throws IOException {
        input();

        recFunc(1);
        System.out.println(sb.toString());
    }

    static void recFunc(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++) {
                if (used[cand] == 1) {
                    continue;
                }
                selected[k] = cand;
                used[cand] = 1;
                recFunc(k + 1);
                selected[k] = 0;
                used[cand] = 0;
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M+1];
        used = new int[N+1];
    }
}
