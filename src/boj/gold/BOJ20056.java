package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ20056 {
    static class Fire {
        int x, y, m, s, d;

        public Fire(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K;
    static ArrayList<Fire> fireList;
    static ArrayList<Fire>[][] map;
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        fireList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireList.add(new Fire(x, y, m, s, d));
        }
    }

    static void check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() == 1) {
                    map[i][j].clear();
                }
                if(map[i][j].size() < 2) continue;

                int massSum = 0;
                int speedSum = 0;

                boolean even = map[i][j].get(0).d % 2 == 0;
                boolean odd = map[i][j].get(0).d % 2 == 1;

                for (Fire now : map[i][j]) {
                    massSum += now.m;
                    speedSum += now.s;
                    even = even & now.d % 2 == 0;
                    odd = odd & now.d % 2 == 1;
                    fireList.remove(now);
                }

                int newMass = massSum / 5;
                int size = map[i][j].size();
                map[i][j].clear();

                if(newMass == 0) continue;
                int newSpeed = speedSum / size;

                if (even | odd) {
                    for (int d = 0; d < 8; d += 2) {
                        fireList.add(new Fire(i, j, newMass, newSpeed, d));
                    }
                } else {
                    for (int d = 1; d < 8; d += 2) {
                        fireList.add(new Fire(i, j, newMass, newSpeed, d));
                    }
                }
            }
        }
    }

    static void move() {
        for (Fire f : fireList) {
            int nx = (f.x + N + dir[f.d][0] * (f.s % N)) % N;
            int ny = (f.y + N + dir[f.d][1] * (f.s % N)) % N;

            f.x = nx;
            f.y = ny;
            map[nx][ny].add(f);
        }
    }

    static void solve() {
        while (K-- > 0) {
            move();
            check();
        }

        int ans = 0;
        for (Fire f : fireList) {
            ans += f.m;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
