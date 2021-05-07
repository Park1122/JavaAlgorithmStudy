package study.datastructure;

public class MySingleLinkedList<T> {
    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (head == null) { //데이터가 아예 없음
            head = new Node<>(data);
        }else{
            Node<T> node = this.head; // head 부터 시작하여, 다음노드가 null 인 , 즉 가장 끝 노드 까지 이동
            while (node.next != null) {
                node = node.next;
            }
            // 현재 node 는 가장 마지막 node 이자, 다음 노드가 없는 상태
            // 즉, node.next == null
            node.next = new Node<>(data);
        }
    }

    public void printAll() {
        if (head != null) { // 데이터가 존재하는 경우에만 실행
            Node<T> node = this.head;
            System.out.print(node.data + " ");
            while (node.next != null) {
                node = node.next;
                System.out.print(node.data + " ");
            }
        }
        System.out.println();
    }

    public Node<T> search(T data) {
        if (this.head != null) {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }

    public void addNodeInside(T data, T isData) {
        Node<T> searchedNode = this.search(isData);

        if (searchedNode == null) {
            this.addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<>(data);
            searchedNode.next.next = nextNode;
        }
    }

    public boolean deleteNode(T isData) {
        if (this.head == null) {
            return false;
        } else {
            Node<T> node = this.head;
            if (node.data == isData) { // head 가 삭제하려는 data 인 경우
                this.head = this.head.next;
                return true;
            } else {
                while (node.next != null) {
                    if (node.next.data == isData) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }

    public static void main(String[] args) {
        MySingleLinkedList<Integer> singleLinkedList = new MySingleLinkedList<>();
        // addNode Test
        System.out.println("==========Add Node==========");
        singleLinkedList.addNode(1);
        singleLinkedList.addNode(3);
        singleLinkedList.addNode(5);
        singleLinkedList.printAll();

        // addNodeInside Test
        System.out.println("==========Add Node Inside==========");
        singleLinkedList.addNodeInside(2, 1);
        singleLinkedList.printAll();
        singleLinkedList.addNodeInside(4, 3);
        singleLinkedList.printAll();
        System.out.println("==========Add Node Inside, but has no selected data==========");
        singleLinkedList.addNodeInside(6, 20);
        singleLinkedList.printAll();

        // deleteNode Test
        System.out.println("==========Delete Node==========");
        singleLinkedList.deleteNode(3);
        singleLinkedList.printAll();
        System.out.println("==========Delete Head Node==========");
        singleLinkedList.deleteNode(1);
        singleLinkedList.printAll();
        System.out.println("==========Delete Tail Node==========");
        singleLinkedList.deleteNode(6);
        singleLinkedList.printAll();
        System.out.println("==========Delete Node, but has no selected data");
        System.out.println(singleLinkedList.deleteNode(20));
    }
}
