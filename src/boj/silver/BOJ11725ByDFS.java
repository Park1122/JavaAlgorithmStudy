package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725ByDFS {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        parent = new int[N + 1];
    }

    // 정점 x의 부모가 par였고, x의 자식들을 찾는 함수
    static void dfs(int x, int par) {
        for (int y : graph[x]) {
            if(y == par) continue;
            parent[y] = x;
            dfs(y, x);
        }
    }

    static void solve() {
        // 1번부터 탐색 시작 -> 단, 루트는 부모를 -1로 가정
        dfs(1, -1);
        // 출력
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
