package study.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int i = 0; i < dataList.size() - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < dataList.size() - 1 - i; j++) {
                if (dataList.get(j) > dataList.get(j + 1)) {
                    Collections.swap(dataList, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
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

        //bubble sort
        BubbleSort bs = new BubbleSort();
        ArrayList<Integer> sortedData = bs.sort(testData);

        //print
        System.out.println(sortedData);
    }
}
