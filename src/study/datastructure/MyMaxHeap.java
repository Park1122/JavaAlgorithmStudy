package study.datastructure;

import java.util.ArrayList;
import java.util.Collections;

public class MyMaxHeap {
    private ArrayList<Integer> heapArray = null;

    public MyMaxHeap(Integer data) {
        heapArray = new ArrayList<>();

        heapArray.add(null); // 1번 인덱스부터 사용하기 위해
        heapArray.add(data);
    }

    public boolean moveUp(Integer insertedIdx) {
        if (insertedIdx <= 1) {
            return false;
        }
        Integer parentIdx = insertedIdx / 2;
        if (this.heapArray.get(insertedIdx) > this.heapArray.get(parentIdx)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insert(Integer data) {
        Integer insertedIdx, parentIdx;

        if (heapArray == null) {
            heapArray = new ArrayList<>();

            heapArray.add(null);
            heapArray.add(data);
            return true;
        }

        this.heapArray.add(data);
        insertedIdx = this.heapArray.size() - 1;

        while (this.moveUp(insertedIdx)) {
            parentIdx = insertedIdx / 2;
            Collections.swap(this.heapArray, insertedIdx, parentIdx);
            insertedIdx = parentIdx;
        }
        return true;
    }

    public boolean moveDown(Integer poppedIdx) {
        Integer leftChildPoppedIdx, rightChildPoppedIdx;

        leftChildPoppedIdx = poppedIdx * 2;
        rightChildPoppedIdx = poppedIdx * 2 + 1;

        // case1: 왼쪽 자식 노드도 없을 때 (자식 노드가 하나도 없을 때)
        if (leftChildPoppedIdx >= this.heapArray.size()) {
            return false;
        } else if (rightChildPoppedIdx >= this.heapArray.size()) { // case2: 오른쪽 자식 노드만 없을 때
            if (this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildPoppedIdx)) {
                return true;
            } else {
                return false;
            }
        } else { //case3: 왼쪽/오른쪽 자식 노드가 모두 있을 때
            if (this.heapArray.get(leftChildPoppedIdx) > this.heapArray.get(rightChildPoppedIdx)) {
                if (this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildPoppedIdx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (this.heapArray.get(poppedIdx) < this.heapArray.get(rightChildPoppedIdx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public Integer pop() {
        Integer returnedData, poppedIdx, leftChildPoppedIdx, rightChildPoppedIdx;

        if (this.heapArray.size() <= 1) {
            return null;
        }
        returnedData = this.heapArray.get(1);
        this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
        this.heapArray.remove(this.heapArray.size() - 1);
        poppedIdx = 1;

        while (moveDown(poppedIdx)) {
            leftChildPoppedIdx = poppedIdx * 2;
            rightChildPoppedIdx = poppedIdx * 2 + 1;

            // case2: 오른쪽 자식 노드만 없을 때
            if (rightChildPoppedIdx >= this.heapArray.size()) {
                if (this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildPoppedIdx)) {
                    Collections.swap(this.heapArray, poppedIdx, leftChildPoppedIdx);
                    poppedIdx = leftChildPoppedIdx;
                }
            } else { //case3: 왼쪽/오른쪽 자식 노드가 모두 있을 때
                if (this.heapArray.get(leftChildPoppedIdx) > this.heapArray.get(rightChildPoppedIdx)) {
                    if (this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildPoppedIdx)) {
                        Collections.swap(this.heapArray, poppedIdx, leftChildPoppedIdx);
                        poppedIdx = leftChildPoppedIdx;
                    }
                } else {
                    if (this.heapArray.get(poppedIdx) < this.heapArray.get(rightChildPoppedIdx)) {
                        Collections.swap(this.heapArray, poppedIdx, rightChildPoppedIdx);
                        poppedIdx = rightChildPoppedIdx;
                    }
                }
            }
        }
        return returnedData;
    }

    public static void main(String[] args) {
        MyMaxHeap heap = new MyMaxHeap(15);
        heap.insert(10);
        heap.insert(8);
        heap.insert(5);
        heap.insert(4);
        heap.insert(20);
        System.out.println(heap.heapArray.toString());

        heap.pop();
        System.out.println(heap.heapArray.toString());
    }
}
