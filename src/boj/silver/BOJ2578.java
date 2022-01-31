package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2578 {
    static int[][] player, host;
    static boolean[] bingo;
    static int bingoCnt, step;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        player = new int[5][5];
        host = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                host[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bingo = new boolean[26];
    }

    static void rowCheck() {
        // 가로줄 빙고 체크
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if(bingo[player[i][j]]) cnt++;
            }
            if(cnt == 5) bingoCnt++;
        }
    }

    static void columnCheck() {
        // 세로줄 빙고 체크
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if(bingo[player[j][i]]) cnt++;
            }
            if(cnt == 5) bingoCnt++;
        }
    }

    static void leftDiaCheck() {
        // 왼쪽 -> 오른쪽 대각선 빙고 체크
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if(bingo[player[i][i]]) cnt++;
        }
        if(cnt == 5) bingoCnt++;
    }

    static void rightDiaCheck() {
        // 오른쪽 -> 왼쪽 대각선 빙고 체크
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if(bingo[player[i][4 - i]]) cnt++;
        }
        if(cnt == 5) bingoCnt++;
    }

    static void solve() {
        step = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bingoCnt = 0;
                bingo[host[i][j]] = true;
                step++;

                rowCheck();
                columnCheck();
                leftDiaCheck();
                rightDiaCheck();

                if (bingoCnt >= 3) {
                    System.out.println(step);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
