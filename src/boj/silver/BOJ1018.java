package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        int min = 64;

        // 체스판 생성
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int count = 0;
                char startColor = board[i][j];

                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        if (board[x][y] != startColor) {
                            count++;
                        }
                        
                        //체크 후 다음 칸 체크 시에는 색이 바뀌므로 미리 기준 색 바꿔두기
                        if (startColor == 'W') {
                            startColor = 'B';
                        } else {
                            startColor = 'W';
                        }
                    }
                    //마지막 색이 W면 끝나고 기준 색이 B로 바뀌는데 다음줄의 첫째는 이전줄의 마지막과 색이 같으니까 다시 원상복구
                    if (startColor == 'W') {
                        startColor = 'B';
                    } else {
                        startColor = 'W';
                    }
                }

                //첫번째 칸 색의 반대되는 경우와 비교
                count = Math.min(count, 64 - count);

                //이전까지의 경우 중 최소값보다 지금 값이 더 작다면 갱신
                min = Math.min(min, count);
            }
        }
        bw.write(min + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
