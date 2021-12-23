package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ2447 {
    static int N;
    static int[] nums;
    static HashMap<Integer, Integer> map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        map = new HashMap<>();
    }

    static void solve() {
        // 정렬을 통해 순서 조작
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        // Map을 이용해서 중복을 제거함과 동시에 자신보다 작은 수의 개수를 value로 가짐
        int idx = 0;
        for (int n : sortedNums) {
            if(map.containsKey(n)) continue;
            map.put(n, idx);
            idx++;
        }

        for (int n : nums) {
            sb.append(map.get(n)).append(' ');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
