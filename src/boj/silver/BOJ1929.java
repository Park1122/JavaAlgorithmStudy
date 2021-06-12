package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] primes = new boolean[n+1]; // 0 ~ n

        // false = 실수
        primes[0] = true;
        primes[1] = true;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if(primes[i] == true) continue; // 배수로 체크가 된 경우는 넘어감
            for (int j = i * i; j < primes.length; j = j+i) {
                primes[j] = true;
            }
        }

        for (int i = m; i <= n; i++) {
            if (!primes[i]) {
                sb.append(i).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
