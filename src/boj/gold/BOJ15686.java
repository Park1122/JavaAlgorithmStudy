package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ15686 {
    static int N, M, min;
    static ArrayList<int[]> chickens;
    static ArrayList<int[]> houses;
    static Stack<int[]> selectChicken;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        selectChicken = new Stack<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    houses.add(new int[]{i, j});
                } else if (num == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        min = Integer.MAX_VALUE;
    }

    static void calcDist() {
        int sum = 0;
        for (int[] house : houses) {
            int temp = Integer.MAX_VALUE;
            for (int[] chicken : selectChicken) {
                int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                temp = Math.min(temp, dist);
            }
            sum += temp;

            if (sum > min) {
                return;
            }
        }
        min = Math.min(sum, min);
    }

    static void recFunc(int start, int cnt) {
        if (cnt == M) {
            calcDist();
        }else{
            for (int i = start; i < chickens.size(); i++) {
                selectChicken.push(chickens.get(i));
                recFunc(i + 1, cnt + 1);
                selectChicken.pop();
            }
        }
    }

    static void solve() {
        recFunc(0, 0);
        System.out.println(min);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

}
