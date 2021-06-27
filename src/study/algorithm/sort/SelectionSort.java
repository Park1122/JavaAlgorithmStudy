package study.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        int min;
        for (int i = 0; i < dataList.size() - 1; i++) {
            min = i;
            for (int j = i + 1; j < dataList.size(); j++) {
                if (dataList.get(min) > dataList.get(j)) {
                    min = j;
                }
            }
            Collections.swap(dataList, min, i);
        }
        return dataList;
    }

    public static void main(String[] args) {
        //create test data
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }

        //selection sort
        SelectionSort ss = new SelectionSort();
        ArrayList<Integer> sortedData = ss.sort(testData);

        //print
        System.out.println(sortedData);
    }
}
