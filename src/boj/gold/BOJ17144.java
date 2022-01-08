package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17144 {
    static class Dust {
        int x, y, amt;

        public Dust(int x, int y, int amt) {
            this.x = x;
            this.y = y;
            this.amt = amt;
        }
    }

    static int R, C, T, cleaner;
    static int[][] A;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        A = new int[R][C];
        cleaner = -1;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (cleaner == -1 && A[i][j] == -1) {
                    cleaner = i;
                }
            }
        }
    }

    // 공기청정기 작동
    static void cleanAir() {
        int top = cleaner;
        int down = cleaner + 1;

        // 1. 위쪽 공기청정기 -> 반시계
        // 아래로 당기기
        for (int i = top - 1; i > 0; i--) {
            A[i][0] = A[i - 1][0];
        }
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) {
            A[0][i] = A[0][i + 1];
        }
        // 위로 당기기
        for (int i = 0; i < top; i++) {
            A[i][C - 1] = A[i + 1][C - 1];
        }
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) {
            A[top][i] = A[top][i - 1];
        }
        A[top][1] = 0;

        // 2. 아래쪽 공기청정기 -> 시계
        // 위로 당기기
        for (int i = down + 1; i < R - 1; i++) {
            A[i][0] = A[i + 1][0];
        }
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) {
            A[R - 1][i] = A[R - 1][i + 1];
        }
        // 아래쪽으로 당기기
        for (int i = R - 1; i > down; i--) {
            A[i][C - 1] = A[i - 1][C - 1];
        }
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) {
            A[down][i] = A[down][i - 1];
        }
        A[down][1] = 0;
    }

    // 미세먼지 확산
    static void bfs() {
        Queue<Dust> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) { // 미세먼지가 있는 경우
                    q.add(new Dust(i, j, A[i][j]));
                }
            }
        }

        while (!q.isEmpty()) {
            Dust now = q.poll();
            if(now.amt < 5) continue;
            int spreadAmt = now.amt / 5;
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dir[d][0];
                int ny = now.y + dir[d][1];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(A[nx][ny] == -1) continue;

                A[nx][ny] += spreadAmt;
                cnt++;
            }

            A[now.x][now.y] -= spreadAmt * cnt;
        }
    }

    static void solve() {
        // T초 동안 실행
        while (T-- > 0) {
            bfs();
            cleanAir();
        }

        // 출력
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(A[i][j] > 0) sum += A[i][j];
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
