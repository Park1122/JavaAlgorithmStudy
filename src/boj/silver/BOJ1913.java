package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1913 {
    // direction -> 0(아래로), 1(우로), 2(위로), 3(좌로)
    static int n, m, direction;
    static int[][] map;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        direction = 0;
        map = new int[n][n];
    }

    static void solve() {
        // 시작 값 및 좌표 할당
        int value = n*n;
        map[0][0] = value;
        int startX = 0;
        int startY = 0;

        while (true) {
            // 새로 이동할 방향의 좌표
            int nx = startX + dir[direction][0];
            int ny = startY + dir[direction][1];

            // 가려고 하는 방향의 좌표가 바깥이거나 이미 값이 채워진 경우에는 방향 돌리기(단, 좌표 갱신 X)
            if(nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != 0) {
                direction++;
                if(direction == 4) direction = 0;
            }else{ // 가도 되는 방향이므로 이전에 넣어진 값에서 1빼고 넣기 및 좌표 갱신
                value--;
                map[nx][ny] = value;
                startX = nx;
                startY = ny;
            }

            // 값이 1까지 넣어진 경우에는 반복 종료
            if(value == 1) {
                break;
            }
        }

        // 출력 및 원하는 숫자의 좌표 찾기
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(' ');
                if (map[i][j] == m) {
                    // 답에서 요구한 좌표는 1부터 시작하는 좌표이므로 1이 더해져야함
                    x = i+1;
                    y = j+1;
                }
            }
            sb.append('\n');
        }
        sb.append(x).append(' ').append(y);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
