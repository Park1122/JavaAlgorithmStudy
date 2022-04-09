package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16472 {
    static int N, kind;
    static String A;
    static int[] cnt;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = br.readLine();
        cnt = new int[26];
    }

    // solve1
//    static void add(char x) {  // x 라는 알파벳 추가
//        cnt[x - 'a']++;
//    }

    // solve2
    static void add(char x) {  // x 라는 알파벳 추가
        cnt[x - 'a']++;
        if(cnt[x - 'a'] == 1) kind++;
    }

    // solve1
//    static void erase(char x) {  // x 라는 알파벳 제거
//        cnt[x - 'a']--;
//    }

    // solve2
    static void erase(char x) {  // x 라는 알파벳 제거
        cnt[x - 'a']--;
        if(cnt[x - 'a'] == 0) kind--;
    }

    static void pro() {
        int len = A.length(), ans = 0;
        for (int R = 0, L = 0; R < len; R++) {
            // R 번째 알파벳를 오른쪽에 추가
            add(A.charAt(R));

            // 불가능하면, 가능할 때까지 L을 이동
            // solve1 - 매번 26개의 알파벳 개수를 체크하는 방법
//            while (true) {
//                kind = 0;
//                // 서로 다른 알파벳 개수 세기
//                for (int i = 0; i < 26; i++) {
//                    if(cnt[i] != 0) kind++;
//                }
//
//                if(kind <= N) break;
//                erase(A.charAt(L));
//                L++;
//            }

            // solve2 - 알파벳이 추가되거나 제거될 때, 서로 다른 알파벳 개수를 바로 카운팅하는 방법
            while (kind > N) {
                erase(A.charAt(L));
                L++;
            }

            // 정답 갱신
            ans = Math.max(ans, R - L + 1);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
