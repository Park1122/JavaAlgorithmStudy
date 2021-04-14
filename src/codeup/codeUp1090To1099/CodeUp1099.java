package codeup.codeUp1090To1099;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1099 {
    public static void main(String[] args) throws IOException {
        // 배열 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arrs = new int[10][10];
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arrs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //개미 이동 시작
        int y = 1; // y값 위치 저장을 위한 변수
        boolean end = false;
        for (int k = 1; k < 10; k++) {
            if (!end) {
                for (int t = y; t < 10; t++) {
                    if (arrs[k][t] == 0) { // 0일 경우, 오른쪽 진행
                        arrs[k][t] = 9;
                    } else if (arrs[k][t] == 2) { // 2일 경우, 9로 만들고 정지
                        arrs[k][t] = 9;
                        end = true;
                        break;
                    }else{ // 1일 경우, 왼쪽 대각선 아래부터 시작하기 위해 y값 위치 조정
                        y = t-1;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        
        //배열 출력
        for (int[] arr : arrs) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
