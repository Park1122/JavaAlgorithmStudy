package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16235 {
    static class Tree implements Comparable<Tree>{
        int x, y, age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    static int N, M, K;
    static int[][] land, A;
    static Queue<Tree> trees;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        land = new int[N + 1][N + 1];
        A = new int[N + 1][N + 1];
        trees = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                land[i][j] = 5;
            }
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, z));
        }
    }

    // 양분 추가
    static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                land[i][j] += A[i][j];
            }
        }
    }

    // 8방향으로 나무 번식
    static void fall() {
        // 어린 나무부터 넣어야하기 때문에 부모 나무는 리스트에 저장해 두고 나중에 큐에 삽입
        ArrayList<Tree> temp = new ArrayList<>();

        int size = trees.size();
        while (size-- > 0) {
            Tree now = trees.poll();

            if (now.age % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                    int nx = now.x + dir[d][0];
                    int ny = now.y + dir[d][1];
                    if(nx < 1 || ny < 1 || nx > N || ny > N) continue;

                    trees.add(new Tree(nx, ny, 1));
                }
            }

            temp.add(now);
        }

        for (Tree t : temp) {
            trees.add(t);
        }
    }

    // 자신의 나이만큼 나무가 양분 먹기(어린 나이의 나무부터)
    // 못먹는 경우에는 죽고, 죽은 나무 나이의 2로 나눈 값이 양분으로 추가
    static void springToSummer() {
        ArrayList<Tree> temp = new ArrayList<>();

        int size = trees.size();
        while (size-- > 0) {
            Tree now = trees.poll();

            if (land[now.x][now.y] - now.age < 0) { // 양분을 먹을 수 없는 경우 -> 나무 죽음
                temp.add(new Tree(now.x, now.y, now.age));
            } else { // 양분을 먹을 수 있는 경우
                land[now.x][now.y] -= now.age;
                trees.add(new Tree(now.x, now.y, now.age + 1));
            }
        }

        // 죽은 나무들은 나이의 절반이 양분으로 추가 됨
        for (Tree t : temp) {
            land[t.x][t.y] += (t.age / 2);
        }
    }

    static void solve() {
        Collections.sort((List<Tree>) trees);

        while (K-- > 0) {
            springToSummer();
            fall();
            winter();
        }

        System.out.println(trees.size());
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
