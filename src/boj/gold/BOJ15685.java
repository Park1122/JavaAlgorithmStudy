package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15685 {
    static int N, ans;
    static boolean[][] map;
    static int[][] inputCurve;
    static int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        inputCurve = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            inputCurve[i][0] = x;
            inputCurve[i][1] = y;
            inputCurve[i][2] = d;
            inputCurve[i][3] = g;
        }
        map = new boolean[101][101];
    }

    static void dragonCurve(int x, int y, int d, int g) {
        ArrayList<Integer> directions = new ArrayList<>();
        directions.add(d);

        while (g-- > 0) { // g세대까지 반복
            for (int j = directions.size() - 1; j >= 0; j--) {
                directions.add((directions.get(j) + 1) % 4);
            }
        }

        map[y][x] = true;
        for (int direction : directions) {
            x += dir[direction][0];
            y += dir[direction][1];
            map[y][x] = true;
        }
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            int[] c = inputCurve[i];
            dragonCurve(c[0], c[1], c[2], c[3]);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
