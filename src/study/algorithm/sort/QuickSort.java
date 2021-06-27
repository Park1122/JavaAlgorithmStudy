package study.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }

        int pivot = dataList.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int i = 1; i < dataList.size(); i++) {
            if (dataList.get(i) > pivot) {
                right.add(dataList.get(i));
            } else {
                left.add(dataList.get(i));
            }
        }

        ArrayList<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(this.sort(left));
        mergedList.addAll(Arrays.asList(pivot));
        mergedList.addAll(this.sort(right));

        return mergedList;
    }

    public static void main(String[] args) {
        //create test data
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }

        //quick sort
        QuickSort qs = new QuickSort();
        ArrayList<Integer> sortedData = qs.sort(testData);

        //print
        System.out.println(sortedData);
    }
}
