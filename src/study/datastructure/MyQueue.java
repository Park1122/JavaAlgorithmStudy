package study.datastructure;

import java.util.ArrayList;

public class MyQueue<T> {
    ArrayList<T> queue = new ArrayList<>();

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            return null;
        } else {
            return queue.remove(0);
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        // 실제 java 에서 Queue 의 경우, Queue 로 선언 후, LinkedList 로 생성하여 사용한다.
        // enqueue -> add, offer 메소드 사용
        // dequeue -> remove, poll 메소드 사용
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue.isEmpty());
    }
}
