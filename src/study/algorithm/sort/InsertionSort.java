package study.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int i = 0; i < dataList.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (dataList.get(j) < dataList.get(j - 1)) {
                    Collections.swap(dataList, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        //create test data
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }

        //insertion sort
        InsertionSort is = new InsertionSort();
        ArrayList<Integer> sortedData = is.sort(testData);

        //print
        System.out.println(sortedData);
    }
}
