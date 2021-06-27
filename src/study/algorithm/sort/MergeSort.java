package study.algorithm.sort;

import java.util.ArrayList;

public class MergeSort {
    public ArrayList<Integer> split(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }

        int mid = dataList.size() / 2;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        left = this.split(new ArrayList<>(dataList.subList(0, mid)));
        right = this.split(new ArrayList<>(dataList.subList(mid, dataList.size())));

        return this.merge(left, right);
    }

    public ArrayList<Integer> merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPointer = 0;
        int rightPointer = 0;

        //case1 : left, right 존재
        while (leftList.size() > leftPointer && rightList.size() > rightPointer) {
            if (leftList.get(leftPointer) > rightList.get(rightPointer)) {
                mergedList.add(rightList.get(rightPointer));
                rightPointer++;
            } else {
                mergedList.add(leftList.get(leftPointer));
                leftPointer++;
            }
        }

        //case2 : right 미존재
        while (leftList.size() > leftPointer) {
            mergedList.add(leftList.get(leftPointer));
            leftPointer++;
        }

        //case3 : left 미존재
        while (rightList.size() > rightPointer) {
            mergedList.add(rightList.get(rightPointer));
            rightPointer++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        //create test data
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }

        //merge sort
        MergeSort ms = new MergeSort();
        ArrayList<Integer> sortedData = ms.split(testData);

        //print
        System.out.println(sortedData);
    }
}
