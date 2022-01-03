package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ3190 {
    static int N, K, L, time, idx;
    static int[][] board;
    static HashMap<Integer, String> transform;
    static List<int[]> snake;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 1;
        }
        transform = new HashMap<>();
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            transform.put(t, d);
        }
        snake = new LinkedList<>();
        // 0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
        // D: idx++, L: idx--
        idx = 0;
    }

    static boolean isFinish(int x, int y) {
        // 벽에 부딪혔는지
        if(x < 1 || y < 1 || x > N || y > N) return true;
        // 몸에 다았는지
        for (int[] info : snake) {
            if (x == info[0] && y == info[1]) {
                return true;
            }
        }

        return false;
    }

    static void solve() {
        snake.add(new int[]{1, 1});
        int x = 1, y = 1;// 현재 움직임
        int nx, ny;//다음 움직임

        while (true) {
            time++;
            nx = x + dir[idx][0];
            ny = y + dir[idx][1];

            if(isFinish(nx, ny)) break;

            // 사과 체크
            if (board[nx][ny] == 1) {
                board[nx][ny] = 0;
                snake.add(new int[]{nx, ny});
            } else {
                snake.add(new int[]{nx, ny});
                snake.remove(0);
            }

            x = nx;
            y = ny;

            // 머리 방향 결정
            if (transform.containsKey(time)) {
                if (transform.get(time).equals("D")) {
                    idx++;
                    if(idx == 4) idx = 0;
                } else if(transform.get(time).equals("L")){
                    idx--;
                    if(idx == -1) idx = 3;
                }
            }
        }

        System.out.println(time);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
