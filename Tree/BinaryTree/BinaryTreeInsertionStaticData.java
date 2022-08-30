package Tree.BinaryTree;

public class BinaryTreeInsertionStaticData {
    Node rootNode;

    static class Node {
        Node leftChild;
        int data;
        Node rightChild;

        Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }

    public static void main(String[] args) {
        BinaryTreeInsertionStaticData binaryTreeInsertionStaticData
                = new BinaryTreeInsertionStaticData();

        //level 0
        binaryTreeInsertionStaticData.rootNode = new Node(10);

        //level 1
        binaryTreeInsertionStaticData.rootNode.leftChild = new Node(20);
        binaryTreeInsertionStaticData.rootNode.rightChild = new Node(30);

        //level 2
        binaryTreeInsertionStaticData.rootNode.leftChild.leftChild = new Node(40);
        binaryTreeInsertionStaticData.rootNode.leftChild.rightChild = new Node(50);
        binaryTreeInsertionStaticData.rootNode.rightChild.leftChild = new Node(60);
        binaryTreeInsertionStaticData.rootNode.rightChild.rightChild = new Node(70);
    }
}
