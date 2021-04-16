package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1974 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                int[][] matrix = new int[9][9];
                for (int i = 0; i < 9; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < 9; j++) {
                        matrix[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                if (!checkWidth(matrix)) {
                    System.out.println("#" + (tc+1) + " " + 0);
                    continue;
                }
                if (!checkHeight(matrix)) {
                    System.out.println("#" + (tc+1) + " " + 0);
                    continue;
                }
                if (!checkSquare(matrix)) {
                    System.out.println("#" + (tc+1) + " " + 0);
                    continue;
                }
                System.out.println("#" + (tc+1) + " " + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkWidth(int[][] matrix) {
        boolean checkedWidth = true;
        for (int i = 0; i < 9; i++) {
            int sum = 0;
            for (int j = 0; j < 9; j++) {
                sum += matrix[i][j];
            }
            if (sum != 45) {
                checkedWidth = false;
                break;
            }
        }
        return checkedWidth;
    }

    public static boolean checkHeight(int[][] matrix) {
        boolean checkedHeight = true;
        for (int i = 0; i < 9; i++) {
            int sum = 0;
            for (int j = 0; j < 9; j++) {
                sum += matrix[j][i];
            }
            if (sum != 45) {
                checkedHeight = false;
                break;
            }
        }
        return checkedHeight;
    }

    public static boolean checkSquare(int[][] matrix) {
        boolean checkedSquare = true;
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                int nx = i+3;
                int ny = j+3;
                int sum = 0;
                for (int k = i; k < nx; k++) {
                    for (int t = j; t < ny; t++) {
                        sum += matrix[k][t];
                    }
                }
                if (sum != 45) {
                    checkedSquare = false;
                }
            }
        }
        return checkedSquare;
    }
}
