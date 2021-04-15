package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시뮬레이션 문제
 */
public class Swea1979 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                //create test case array
                int[][] arr = new int[n][n];
                for (int j = 0; j < n; j++) {
                    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                    for (int x = 0; x < n; x++) {
                        arr[j][x] = Integer.parseInt(tokenizer.nextToken());
                    }
                }

                int count = 0;
                for (int i = 0; i < n; i++) {
                    int rowCheck = 0;
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j] == 0) {
                            if (rowCheck == k) {
                                count++;
                            }
                            rowCheck = 0;
                        } else {
                            rowCheck++;
                        }
                    }
                    if (rowCheck == k) {
                        count++;
                    }
                }
                for (int i = 0; i < n; i++) {
                    int columnCheck = 0;
                    for (int j = 0; j < n; j++) {
                        if (arr[j][i] == 0) {
                            if (columnCheck == k) {
                                count++;
                            }
                            columnCheck = 0;
                        } else {
                            columnCheck++;
                        }
                    }
                    if (columnCheck == k) {
                        count++;
                    }
                }
                System.out.println("#" + (tc+1) + " " + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
