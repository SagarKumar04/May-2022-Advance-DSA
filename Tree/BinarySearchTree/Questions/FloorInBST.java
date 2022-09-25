package Tree.BinarySearchTree.Questions;

import java.util.Scanner;

public class FloorInBST {
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

    private Node insertNode(Node currentNode, int data) {
        if(currentNode == null) {
            Node newNode = new Node(data);
            currentNode = newNode;
        }
        else {
            if(data <= currentNode.data) {
                currentNode.leftChild = insertNode(currentNode.leftChild, data);
            }
            else {
                currentNode.rightChild = insertNode(currentNode.rightChild, data);
            }
        }

        return currentNode;
    }

    private int getFloorOfBST(Node currentNode, int X) {
        if(currentNode == null) {
            return -1;
        }

        if(currentNode.data == X) {
            return currentNode.data;
        }

        if(currentNode.data > X) {
            return getFloorOfBST(currentNode.leftChild, X);
        }

        int floorInRightSubtree = getFloorOfBST(currentNode.rightChild, X);

        return (
                (floorInRightSubtree < X && floorInRightSubtree != -1) ?
                        floorInRightSubtree : currentNode.data
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        FloorInBST floorInBST = new FloorInBST();

        for(int i = 0; i < N; i++) {
            int data = scanner.nextInt();
            floorInBST.rootNode = floorInBST.insertNode(floorInBST.rootNode, data);
        }

        int X = scanner.nextInt();

        int floor = floorInBST.getFloorOfBST(floorInBST.rootNode, X);

        System.out.println(floor);
    }
}
