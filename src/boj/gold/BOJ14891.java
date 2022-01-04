package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14891 {
    static int k;
    static int[][] wheel, temp; // [번호][방향]
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        wheel = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = str.charAt(j) - '0';
            }
        }
        k = Integer.parseInt(br.readLine());
        temp = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            temp[i][0] = idx;
            temp[i][1] = dir;
        }
    }

    // 왼쪽 톱니바퀴 회전 여부 결정
    static void left(int idx, int dir) {
        if(idx < 0) return;
        if (wheel[idx][2] != wheel[idx + 1][6]) {
            left(idx - 1, -dir);
            rotate(idx, dir);
        }
    }

    // 오른쪽 톱니바퀴 회전 여부 결정
    static void right(int idx, int dir) {
        if(idx > 3) return;

        if (wheel[idx][6] != wheel[idx - 1][2]) {
            right(idx + 1, -dir);
            rotate(idx, dir);
        }
    }

    // dir -> 1: 시계방향, -1: 반시계방향
    static void rotate(int idx, int dir) {
        if (dir == 1) {
            int temp = wheel[idx][7];
            for (int i = 7; i > 0; i--) {
                wheel[idx][i] = wheel[idx][i - 1];
            }
            wheel[idx][0] = temp;
        } else {
            int temp = wheel[idx][0];
            for (int i = 0; i < 7; i++) {
                wheel[idx][i] = wheel[idx][i + 1];
            }
            wheel[idx][7] = temp;
        }
    }

    static void pro(int idx, int dir) {
        left(idx - 1, -dir);
        right(idx + 1, -dir);
        rotate(idx, dir);
    }

    static void solve() {
        for (int i = 0; i < k; i++) {
            pro(temp[i][0] - 1, temp[i][1]);
        }

        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans += wheel[i][0] * (1 << i);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
