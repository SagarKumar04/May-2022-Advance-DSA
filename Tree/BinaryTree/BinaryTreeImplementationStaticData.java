package Tree.BinaryTree;

public class BinaryTreeImplementationStaticData {
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
        BinaryTreeImplementationStaticData binaryTreeImplementationStaticData
                = new BinaryTreeImplementationStaticData();

        //level 0
        binaryTreeImplementationStaticData.rootNode = new Node(10);

        //level 1
        binaryTreeImplementationStaticData.rootNode.leftChild = new Node(20);
        binaryTreeImplementationStaticData.rootNode.rightChild = new Node(30);

        //level 2
        binaryTreeImplementationStaticData.rootNode.leftChild.leftChild = new Node(40);
        binaryTreeImplementationStaticData.rootNode.leftChild.rightChild = new Node(50);
        binaryTreeImplementationStaticData.rootNode.rightChild.leftChild = new Node(60);
        binaryTreeImplementationStaticData.rootNode.rightChild.rightChild = new Node(70);
    }
}
