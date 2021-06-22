package study.util.bruteforce;

import java.util.Arrays;

public class PermutationAndCombination {
    static int[] arr = {1, 2, 3, 4, 5};

    /**
     * @param r 뽑고자 하는 개수
     * @param temp r개를 뽑은 결과값을 저장해놓는 배열
     * @param current 현재 개수를 저장해 놓는 값
     * @param start 그 다음 반복문을 시작하는 값
     */
    // 조합 - n개 중에서 r개를 순서 상관없이 선택하는 경우의 수
    // nCr
    private static void doCombination(int r, int[] temp, int current, int start) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
        } else {
            for(int i = start; i<arr.length; i++){
                temp[current] = arr[i];
                doCombination(r, temp, current + 1, i + 1);
            }
        }
    }

    // 중복조합 - n개 중에서 중복을 포함하여 r개를 순서 상관없이 선택하는 경우의 수
    // (n+r-1)Cr
    private static void doOverlapCombination(int r, int[] temp, int current, int start) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
        } else {
            for (int i = start; i < arr.length; i++) {
                temp[current] = arr[i];
                doOverlapCombination(r, temp, current + 1, i);
            }
        }
    }

    /**
     * @param r : 뽑고자 하는 개수
     * @param temp : r개를 뽑는 결과값을 저장해놓는 배열
     * @param current : 현재 개수를 저장해 놓는 값
     * @param visited : 방문 여부를 확인하는 배열
     */
    // 순열 - n개 중에서 r개를 순서 상관있게 선택하는 경우의 수
    // nPr
    private static void doPermutation(int r, int[] temp, int current, boolean[] visited) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp[current] = arr[i];
                    doPermutation(r, temp, current + 1, visited);
                    visited[i] = false;
                }
            }
        }
    }

    // 중복순열 - n개 중에서 중복을 포함하여 r개를 순서 상관있게 선택하는 경우의 수
    // n^r
    private static void doOverlapPermutation(int r, int[] temp, int current) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
        } else {
            for (int i = 0; i < arr.length; i++) {
                temp[current] = arr[i];
                doOverlapPermutation(r, temp, current + 1);
            }
        }
    }
}
