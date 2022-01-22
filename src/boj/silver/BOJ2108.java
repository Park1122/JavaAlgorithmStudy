package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2108 {
    static int N;
    static int[] nums;
    static HashSet<Integer> set;
    static HashMap<Integer, Integer> map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        set = new HashSet<>();
        nums = new int[N];
    }

    static int getRange() {
        return nums[N - 1] - nums[0];
    }

    static int getMode(HashMap<Integer, Integer> map) {
        int freq = Integer.MIN_VALUE;
        ArrayList<Integer> temp = new ArrayList<>();

        // 최빈 횟수 구하기
        for (int n : set) {
            int k = map.get(n);
            if (freq < k) {
                freq = k;
            }
        }

        // 최빈 횟수에 해당하는 key 뽑기
        for (int n : set) {
            int k = map.get(n);
            if (freq == k) {
                temp.add(n);
            }
        }

        Collections.sort(temp);
        return temp.size() > 1 ? temp.get(1) : temp.get(0);
    }

    static int getMid() {
        return nums[N/2];
    }

    static int getAvg(int sum) {
        return (int) Math.round((double)sum / (double)N);
    }

    static void solve() throws IOException {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            sum += n;
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
            set.add(n);
            nums[i] = n;
        }

        int mode = getMode(map);
        Arrays.sort(nums);

        sb.append(getAvg(sum)).append('\n');
        sb.append(getMid()).append('\n');
        sb.append(mode).append('\n');
        sb.append(getRange()).append('\n');

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
