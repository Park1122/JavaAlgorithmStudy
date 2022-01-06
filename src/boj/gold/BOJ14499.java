package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] commands, dice;
    // 1: 동, 2: 서, 3: 북, 4: 남
    static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        commands = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }
        dice = new int[7];
    }

    static void changeDice(int c) {
        int[] temp = dice.clone();
        // 6: 밑면, 1: 윗면
        // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
        if (c == 1) {
            dice[1] = temp[4];
            dice[3] = temp[1];
            dice[4] = temp[6];
            dice[6] = temp[3];
        } else if (c == 2) {
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[4] = temp[1];
            dice[6] = temp[4];
        } else if (c == 3) {
            dice[1] = temp[5];
            dice[2] = temp[1];
            dice[5] = temp[6];
            dice[6] = temp[2];
        } else {
            dice[1] = temp[2];
            dice[2] = temp[6];
            dice[5] = temp[1];
            dice[6] = temp[5];
        }
    }

    static void solve() {
        for (int i = 0; i < K; i++) {
            int command = commands[i];
            int nx = x + dir[command - 1][0];
            int ny = y + dir[command - 1][1];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) { // 이동시 이탈안한 경우
                changeDice(command);

                if (map[nx][ny] == 0) {
                    map[nx][ny] = dice[6];
                } else {
                    dice[6] = map[nx][ny];
                    map[nx][ny] = 0;
                }

                x = nx;
                y = ny;
                sb.append(dice[1]).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
