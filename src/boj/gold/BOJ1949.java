package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1949 {
    static int N;
    static int[] num;
    static ArrayList<Integer>[] con;
    static int[][] Dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N + 1];
        con = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            con[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            con[x].add(y);
            con[y].add(x);
        }
    }

    static void dfs(int x, int prev) {
        Dy[x][0] = 0;
        Dy[x][1] = num[x];

        for (int y : con[x]) {
            if(y == prev) continue;
            dfs(y, x);
            Dy[x][0] += Math.max(Dy[y][0], Dy[y][1]);
            Dy[x][1] += Dy[y][0];
        }
    }

    static void solve() {
        Dy = new int[N + 1][2]; // Dy[i][0]: i라는 root를 포함하는 최대의 주민수, Dy[i][1]: i라는 root 미포함 최대 주민수

        dfs(1, -1);

        System.out.println(Math.max(Dy[1][0], Dy[1][1]));
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
