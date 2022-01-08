package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://girawhale.tistory.com/39
 */
public class BOJ16236 {
    static int N;
    static int[] now;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    now = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }
    }

    static void solve() {
        int size = 2, eat = 0, move = 0;

        while (true) {
            // 거리가 가까운순 -> 더 위에 있는 순 -> 더 왼쪽에 있는 순
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? o1[2] - o2[2] : (o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]));
            boolean[][] visit = new boolean[N][N];

            pq.add(new int[]{now[0], now[1], 0}); // x좌표, y좌표, 이동거리
            visit[now[0]][now[1]] = true;

            boolean isEaten = false;

            while (!pq.isEmpty()) {
                now = pq.poll();

                // 먹이가 존재 & 사이즈도 상어보다 작음 -> 물고기 섭취
                if (map[now[0]][now[1]] != 0 && map[now[0]][now[1]] < size) {
                    map[now[0]][now[1]] = 0;
                    eat++;
                    move += now[2];
                    isEaten = true;
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = now[0] + dir[k][0];
                    int ny = now[1] + dir[k][1];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(visit[nx][ny]) continue;
                    if(map[nx][ny] > size) continue;

                    pq.add(new int[]{nx, ny, now[2] + 1});
                    visit[nx][ny] = true;
                }
            }
            
            if(!isEaten) break; // 큐가 비워질 때까지 먹은 적이 없는 경우에는 물고기가 없으므로 반복문 탈출
            if (size == eat) {
                size++;
                eat = 0;
            }
        }

        System.out.println(move);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
