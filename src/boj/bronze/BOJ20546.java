package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20546 {
    static int criteria;
    static int[] prices;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        criteria = Integer.parseInt(br.readLine());
        prices = new int[15];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 14; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int jun = criteria, sung = criteria;
        int junStock = 0, sungStock = 0;

        // 준현
        for (int i = 1; i <= 14; i++) {
            int today = prices[i];
            if (jun >= today) {
                junStock += jun / today;
                jun %= today;
            }
        }

        // 성민
        for (int i = 4; i <= 14; i++) {
            int price = prices[i];

            if(prices[i-3] < prices[i-2] && prices[i-2] < prices[i-1] && prices[i-1] < price) {
                // 3일 연속 상승 -> 매도
                sung += price * sungStock;
                sungStock = 0;
            } else if (prices[i - 3] > prices[i - 2] && prices[i - 2] > prices[i - 1] && prices[i - 1] > price) {
                // 3일 연속 하락 -> 매수
                sungStock += sung / price;
                sung %= price;
            }
        }

        // 계산
        int totalJun = jun + prices[14] * junStock;
        int totalSung = sung + prices[14] * sungStock;

        if (totalJun > totalSung) {
            System.out.println("BNP");
        } else if (totalJun < totalSung) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
