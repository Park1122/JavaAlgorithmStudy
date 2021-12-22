package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1002 {
    static int x1,y1,r1,x2,y2,r2, dis;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        dis = (int)(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2)); // 중점 사이의 거리의 제곱
    }

    static void solve() {
        // case 1 : 중점같고, 반지름 같은 경우
        if(x1 == x2 && y1 == y2 && r1 == r2) {
            sb.append(-1);
        } else if(dis > Math.pow(r1 + r2, 2)) { // case 2-1 : 두 원의 반지름 합보다 중점간 거리가 더 길 때
            sb.append(0);
        } else if(dis < Math.pow(r2 - r1, 2)) { // case 2-2 : 원 안에 원이 있으나 내접하지 않을 때
            sb.append(0);
        } else if(dis == Math.pow(r2 - r1, 2)) { // case 3-1 : 내접할 때
            sb.append(1);
        } else if(dis == Math.pow(r1 + r2, 2)) { // case 3-2 : 외접할 때
            sb.append(1);
        } else {
            sb.append(2);
        }
        sb.append('\n');
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            input();
            solve();
        }
        System.out.println(sb);
    }
}
