package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17822 {
    static int N, M, T;
    static int[][] tt;
    static ArrayList<Integer>[] list;
    static boolean isChanged;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        tt = new int[T][3];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            tt[i][0] = x;
            tt[i][1] = d;
            tt[i][2] = k;
        }
    }

    public static void cal() {
        int sum = 0;
        int count = 0;

        for(int a = 1; a <= N; a++){
            for(int b = 0; b < M; b++)
                if(list[a].get(b) != -1) {
                    sum += list[a].get(b);
                    count++;
                }
        }
        if(count == 0) return;

        double avg = (double) sum / count;
        for(int a = 1; a <= N; a++){
            for(int b = 0; b < M; b++) {
                if(list[a].get(b) != -1) {
                    if(list[a].get(b) > avg)
                        list[a].set(b, list[a].get(b) - 1);
                    else
                    if(list[a].get(b) < avg)
                        list[a].set(b, list[a].get(b) + 1);
                }
            }
        }
    }

    static int sum() {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (list[i].get(j) != -1) {
                    sum += list[i].get(j);
                }
            }
        }
        return sum;
    }

    static void check(int x, int y, int val) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if (ny == M) {
                ny = 0;
            }
            if (ny == -1) {
                ny = M - 1;
            }

            if(nx < 1 || nx > N) continue;
            if (list[nx].get(ny) == val && list[nx].get(ny) != -1) {
                list[nx].set(ny, -1);
                isChanged = true;
                check(nx, ny, val);
            }
        }
    }

    static void rotate(int x, int d, int k) {
        for (int i = 1; i <= N; i++) {
            if (i % x == 0) {
                if (d == 0) {
                    for (int j = 0; j < k; j++) {
                        list[i].add(0, list[i].remove(list[i].size() - 1));
                    }
                } else {
                    for (int j = 0; j < k; j++) {
                        int n = list[i].remove(0);
                        list[i].add(list[i].size(), n);
                    }
                }
            }
        }
    }

    static void solve() {
        for (int i = 0; i < T; i++) {
            isChanged = false;
            rotate(tt[i][0], tt[i][1], tt[i][2]);
            for (int a = 1; a <= N; a++) {
                for (int b = 0; b < M; b++) {
                    if (list[a].get(b) != -1) {
                        check(a, b, list[a].get(b));
                    }
                }
            }

            if (!isChanged) {
                cal();
            }
        }

        System.out.println(sum());
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
