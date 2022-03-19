package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ11652 {
    static int n, cnt;
    static long val;
    static long[] nums;
    static HashMap<Long, Integer> map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        nums = new long[n];
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }
        cnt = Integer.MIN_VALUE;
        val = Long.MAX_VALUE;
    }

    static void solve() {
        for (long i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (long key : map.keySet()) {
            if (cnt < map.get(key)) {
                val = key;
                cnt = map.get(key);
            } else if (cnt == map.get(key)) {
                val = Math.min(key, val);
            }
        }

        System.out.println(val);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
