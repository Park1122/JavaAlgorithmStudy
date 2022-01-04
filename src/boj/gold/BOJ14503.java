package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
    // d -> 0: 북, 1: 동, 2: 남, 3: 서
    static int N, M, r, c, d, ans;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북 동 남 서
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    /*
    알고리즘
    1. 현재 위치 청소
    2. 반시계 방향으로 돌면서 주변을 청소할 수 있는지 확인
        - 청소할 수 있는 공간이면 1번 수행 (왼쪽 위치를 파라미터로 넘김)
    3. 주변이 모두 청소되어 있거나 벽인 경우
        - 바라보는 방향을 유지한 채 1번 수행 (뒤쪽 위치를 파라미터로 넘김)
     */
    static void clean(int row, int col, int direction) {
        // 1. 현재 위치 청소
        if (map[row][col] == 0) {
            map[row][col] = 2;
            ans++;
        }

        // 2. 왼쪽 방향부터 탐색 진행
        boolean isNotClean = false;
        int origin = direction;
        for (int i = 0; i < 4; i++) {
            int nextDir = (direction + 3) % 4;
            int nx = row + dir[nextDir][0];
            int ny = col + dir[nextDir][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (map[nx][ny] == 0) { // 아직 청소하지 않은 공간인 경우
                clean(nx, ny, nextDir);
                isNotClean = true;
                break;
            }
            direction = (direction + 3) % 4;
        }

        // 네방향 모두 청소가 되어있거나 벽인 경우
        if (!isNotClean) {
            int nextDir = (origin + 2) % 4;
            int nx = row + dir[nextDir][0];
            int ny = col + dir[nextDir][1];

            if (nx > 0 && ny > 0 && nx < N && ny < M) {
                if (map[nx][ny] != 1) {
                    clean(nx, ny, origin);
                }
            }
        }
    }

    static void solve() {
        clean(r, c, d);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
