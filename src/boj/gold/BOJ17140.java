package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ17140 {
    static class Num implements Comparable<Num>{
        int n, len;

        public Num(int n, int len) {
            this.n = n;
            this.len = len;
        }

        @Override
        public int compareTo(Num o) {
            if (this.len == o.len) {
                return this.n - o.n;
            }
            return this.len - o.len;
        }
    }

    static int r, c, k;
    static int[][] A;
    static int[] cnt;
    static ArrayList<Num> list;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        A = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        int time = -1;
        while (true) {
            time++;
            if (time > 100) { // 100초 지나도 못찾은 경우
                time = -1;
                break;
            }

            if (r < A.length && c < A[0].length) { // 문제 요구사항에 맞는 경우를 찾은 경우
                if(A[r][c] == k) break;
            }

            int row = A.length;
            int col = A[0].length;
            int[][] temp = new int[101][101];

            if(row >= col) { // R 연산
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < row; i++) {
                    cnt = new int[101];
                    for (int j = 0; j < col; j++) {
                        if(A[i][j] == 0) continue;
                        int n = A[i][j];
                        cnt[n]++;
                    }

                    list = new ArrayList<>();

                    for (int j = 1; j < cnt.length; j++) {
                        if(cnt[j] != 0){
                            list.add(new Num(j, cnt[j]));
                        }
                    }

                    Collections.sort(list);

                    int z = 0;
                    for (int j = 0; j < list.size(); j++) {
                        temp[i][z] = list.get(j).n;
                        temp[i][z+1] = list.get(j).len;
                        z+=2;
                    }

                    if(max < list.size()*2) max = list.size()*2;
                }
                if(max > 100) max = 100;

                A = new int[row][max];
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < A[i].length; j++) {
                        A[i][j] = temp[i][j];
                    }
                }
            } else { // C 연산
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < col; i++) {
                    cnt = new int[101];
                    for (int j = 0; j < row; j++) {
                        if(A[j][i] == 0) continue;
                        int n = A[j][i];
                        cnt[n]++;
                    }

                    list = new ArrayList<>();

                    for (int j = 1; j < cnt.length; j++) {
                        if(cnt[j] != 0){
                            list.add(new Num(j, cnt[j]));
                        }
                    }

                    Collections.sort(list);

                    int z = 0;
                    for (int j = 0; j < list.size(); j++) {
                        temp[z][i] = list.get(j).n;
                        temp[z+1][i] = list.get(j).len;
                        z+=2;
                    }

                    if(max < list.size()*2) max = list.size()*2;
                }
                if(max > 100) max = 100;

                A = new int[max][col];
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < A[i].length; j++) {
                        A[i][j] = temp[i][j];
                    }
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
