package boj.silver;

import java.io.*;

public class BOJ1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        //각 n에 대한 0과 1의 개수를 배열에 저장
        int[] zeroCount = new int[41];
        int[] oneCount = new int[41];
        zeroCount[0] = 1;
        oneCount[0] = 0;
        zeroCount[1] = 0;
        oneCount[1] = 1;

        // 점화식
        // n의 0의 개수 = n-1의 0의 개수 + n-2의 0의 개수
        // n의 1의 개수 = n-1의 1의 개수 + n-2의 1의 개수
        for (int j = 2; j < 41; j++) {
            zeroCount[j] = zeroCount[j - 1] + zeroCount[j - 2];
            oneCount[j] = oneCount[j - 1] + oneCount[j - 2];
        }

        //입력으로 주어지는 n에 대한 0과 1의 개수 출력
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(zeroCount[n] + " " + oneCount[n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
