package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20057 {
    static int N;
    static int[][] map;
    static int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // 토네이도 이동 방향
    static int[] dc = {1, 1, 2, 2}; // 토네이도의 각 방향으로 이동하는 횟수
    static int[][] dsx = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},    //모래가 퍼지는 x방향
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
    static int[][] dsy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},    //모래가 퍼지는 y방향
            {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
    static int[] sandRatio ={1,1,2,7,7,2,10,10,5};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // 현재 위치에서 이동 -> 이동한 위치에 모래 뿌리기 -> 이동한 위치를 현재위치로 갱신
    static int calculateOutSand(int x, int y) {
        int totalOutSand = 0;

        int currentX = x;
        int currentY = y;

        while (true) {
            for (int d = 0; d < 4; d++) {
                for (int moveCnt = 0; moveCnt < dc[d]; moveCnt++) {
                    // 현재 위치에서 이동
                    int nx = currentX + dir[d][0];
                    int ny = currentY + dir[d][1];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        return totalOutSand;
                    }
                    
                    // 이동한 위치에 모래 뿌리기
                    int sand = map[nx][ny];
                    map[nx][ny] = 0;
                    int spreadTotal = 0;

                    for (int spread = 0; spread < 9; spread++) { // 9방향으로 퍼짐
                        int sandX = nx + dsx[d][spread];
                        int sandY = ny + dsy[d][spread];
                        int spreadAmount = (sand * sandRatio[spread]) / 100;

                        if (sandX < 0 || sandY < 0 || sandX >= N || sandY >= N) {
                            totalOutSand += spreadAmount;
                        } else {
                            map[sandX][sandY] += spreadAmount;
                        }
                        spreadTotal += spreadAmount;
                    }

                    // 알파 부분 계산
                    int alphaX = nx + dir[d][0];
                    int alphaY = ny + dir[d][1];
                    int alphaAmount = sand - spreadTotal;
                    if (alphaX < 0 || alphaY < 0 || alphaX >= N || alphaY >= N) {
                        totalOutSand += alphaAmount;
                    } else {
                        map[alphaX][alphaY] += alphaAmount;
                    }

                    // 위치 갱신
                    currentX = nx;
                    currentY = ny;
                }
            }

            // 이동 횟수 갱신
            for (int idx = 0; idx < 4; idx++) {
                dc[idx] += 2;
            }
        }
    }

    static void solve() {
        int res = calculateOutSand(N / 2, N / 2);
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
