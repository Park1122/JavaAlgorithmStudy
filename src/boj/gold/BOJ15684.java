package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15684 {
    static int N, M, H, ans;
    //map[i][j] -> value  0: 가로선 없음, 1: 우측으로 연결되는 가로선 존재, 2: 좌측으로 연결되는 가로선 존재
    static int[][] map;
    static boolean isFinish;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // a 높이에서 b번과 b+1번 연결
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[a][b + 1] = 2;
        }
    }

    // i번 출발 i번 도착 체크
    static boolean check() {
        for (int i = 0; i <= N; i++) {
            int nx = 1;
            int ny = i;

            while (nx <= H) {
                if(map[nx][ny] == 1) ny++; // 우측 이동
                else if(map[nx][ny] == 2) ny--; // 좌측 이동
                nx++; // 아래로 한칸 이동
            }

            if (ny != i) {
                return false;
            }
        }
        return true;
    }

    static void recFunc(int x, int y, int cnt) {
        if(isFinish) return;
        if (cnt == ans) {
            if (check()) {
                isFinish = true;
            }
        } else {
            for (int i = x; i <= H; i++) {
                for (int j = y; j < N; j++) {
                    // 연결된 가로선이 없을 때만 가능
                    if (map[i][j] == 0 && map[i][j + 1] == 0) {
                        // 가로선 추가
                        map[i][j] = 1;
                        map[i][j + 1] = 2;

                        recFunc(1, 1, cnt + 1);

                        map[i][j] = 0;
                        map[i][j + 1] = 0;
                    }
                }
            }
        }
    }

    static void solve() {
        for (int i = 0; i <= 3; i++) { // 추가할 가로선의 수
            ans = i;
            recFunc(1, 1, 0);
            if(isFinish) break;
        }

        System.out.println(isFinish ? ans : -1);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
