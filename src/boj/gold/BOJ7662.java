package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ7662 { // TreeMap 사용 -> HashMap과 다르게 Tree의 형태로 저장되어 오름차순 정렬됨.
    static int T, K;
    static TreeMap<Integer, Integer> treeMap;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        K = Integer.parseInt(br.readLine());
        treeMap = new TreeMap<>();
    }

    static void solve() throws IOException {
        StringTokenizer st;
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            int operand = Integer.parseInt(st.nextToken());
            if (operator.equals("I")) {
                iOperate(operand);
            } else {
                dOperate(operand);
            }
        }

        if (treeMap.isEmpty()) {
            sb.append("EMPTY");
        } else {
            sb.append(treeMap.lastKey()).append(' ').append(treeMap.firstKey());
        }
        sb.append('\n');
    }

    static void iOperate(int operand) {
        treeMap.put(operand, treeMap.getOrDefault(operand, 0) + 1);
    }

    static void dOperate(int operand) {
        if(treeMap.isEmpty()) return;

        // Short explanation
        int key = (operand == 1 ? treeMap.lastKey() : treeMap.firstKey());
        if (treeMap.put(key, treeMap.get(key) - 1) == 1) {//put의 경우 key에 value를 넣기 전 기존 value를 반환해줌
            treeMap.remove(key);
        }

        // Long explanation
//        if (operand == 1) {
//            int maxKey = treeMap.lastKey();
//            if (treeMap.get(maxKey) == 1) {
//                treeMap.remove(maxKey);
//            } else {
//                treeMap.put(maxKey, treeMap.get(maxKey) - 1);
//            }
//        } else {
//            int minKey = treeMap.firstKey();
//            if (treeMap.get(minKey) == 1) {
//                treeMap.remove(minKey);
//            } else {
//                treeMap.put(minKey, treeMap.get(minKey) - 1);
//            }
//        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            input();
            solve();
        }
        System.out.println(sb);
    }
}
