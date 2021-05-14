package study.datastructure;

public class MyBinarySearchTree {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;
        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data) {
        if (this.head == null) { // case1: Node 가 하나도 없을 때
            this.head = new Node(data);
        } else { // case2: Node 가 하나 이상 있을 때
            Node findNode = this.head;
            while (true) {
                if (data < findNode.value) {// case2-1: 현재 Node 의 왼쪽에 들어가야 할 때
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                } else {// case2-2: 현재 Node 의 오른쪽에 들어가야 할 때
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node search(int data) {
        if (this.head == null) { // case1: Node 가 하나도 없을 때
            return null;
        } else { // case2: Node 가 하나 이상 있을 때
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }

    public boolean delete(int value) {
        boolean searched = false;

        Node currentParentNode = this.head;
        Node currentNode = this.head;

        // 일단은 삭제할 데이터를 갖고 있는 Node 부터 찾기
        if (this.head == null) { // corner case1: Node 가 하나도 없을 때
            return false;
        } else { // corner case2: Node 가 하나만 있는데, 하나 있는 Node 가 삭제할 Node 일 때
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            while (currentNode != null) {
                if (currentNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currentNode.value) {
                    currentParentNode = currentNode;
                    currentNode = currentNode.left;
                } else {
                    currentParentNode = currentNode;
                    currentNode = currentNode.right;
                }
            }

            if (searched == false) {
                return false;
            }
        }

        // 삭제할 데이터를 갖고 있는 Node 가 찾아진 경우
        // 여기까지 실행되는 경우,
        // currentNode 에는 삭제할 데이터를 가지고 있는 Node 가 되고,
        // currentParentNode 에는 삭제할 데이터를 가지고 있는 Node 의 부모 Node 가 된다.

        // case1: 삭제할 Node 가 Leaf Node 인 경우
        if (currentNode.left == null && currentNode.right == null) {
            if (value < currentParentNode.value) {
                currentParentNode.left = null;
                currentNode = null;
            } else {
                currentParentNode.right = null;
                currentNode = null;
            }
            return true;
        } else if (currentNode.left != null && currentNode.right == null) { // Case2-1: 삭제할 Node 가 Child Node 를 한 개 가지고 있을 경우 (왼쪽에 Child Node 가 있을 경우)
            if (value < currentParentNode.value) {
                currentParentNode.left = currentNode.left;
                currentNode = null;
            } else {
                currentParentNode.right = currentNode.left;
                currentNode = null;
            }
            return true;
        } else if (currentNode.left == null && currentNode.right != null) { // Case2-2: 삭제할 Node 가 Child Node를 한 개 가지고 있을 경우 (오른쪽에 Child Node 가 있을 경우)
            if (value < currentParentNode.value) {
                currentParentNode.left = currentNode.right;
                currentNode = null;
            } else {
                currentParentNode.right = currentNode.right;
                currentNode = null;
            }
            return true;
        } else {
            // case3-1: 삭제할 Node 가 Child Node 를 2개 갖고 있는 경우 (삭제할 Node 가 부모 Node 의 왼쪽에 있을 때)
            if (value < currentParentNode.value) {
                Node changeNode = currentNode.right;
                Node changeParentNode = currentNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                // changeNode 에는 삭제할 Node 의 오른쪽 Node 들 중에서 
                // 가장 작은 Node 가 들어가게 됨

                if (changeNode.right != null) { // case3-1-2: changeNode 의 오른쪽 Child Node 가 있을 때
                    changeParentNode.left = changeNode.right;
                } else { // case3-1-1: changeNode 의 Child Node 가 없을 때
                    changeParentNode.left = null;
                }
                // changeNode(가져와 붙일 Node)를 currentParentNode 의 왼쪽에 붙인다.
                currentParentNode.left = changeNode;

                // parentNode 의 왼쪽 Child Node 가 현재 changeNode 이고,
                // changeNode 의 왼쪽/오른쪽 Child Node 를 모두,
                // 삭제될 currentNode 에 붙어있던 왼쪽/오른쪽 Node 로 변경
                changeNode.right = currentNode.right;
                changeNode.left = currentNode.left;

                currentNode = null;
            } else { // Case3-2: 삭제할 Node 가 Child Node 를 2개 갖고 있는 경우 (삭제할 Node 가 부모 Node 의 오른쪽에 있을 때)
                Node changeNode = currentNode.right;
                Node changeParentNode = currentNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                // changeNode 에는 삭제할 Node 의 오른쪽 Node 들 중에서
                // 가장 작은 Node 가 들어가게 됨

                if (changeNode.right != null) { // case3-1-2: changeNode 의 오른쪽 Child Node 가 있을 때
                    changeParentNode.left = changeNode.right;
                } else { // case3-1-1: changeNode 의 Child Node 가 없을 때
                    changeParentNode.left = null;
                }
                // changeNode(가져와 붙일 Node)를 currentParentNode 의 왼쪽에 붙인다.
                currentParentNode.right = changeNode;

                // parentNode 의 왼쪽 Child Node 가 현재 changeNode 이고,
                // changeNode 의 왼쪽/오른쪽 Child Node 를 모두,
                // 삭제될 currentNode 에 붙어있던 왼쪽/오른쪽 Node 로 변경
                changeNode.right = currentNode.right;
                changeNode.left = currentNode.left;

                currentNode = null;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        MyBinarySearchTree myTree = new MyBinarySearchTree();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);

        System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.head.value);

        System.out.println("==========================");

        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("==========================");

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
    }
}
