package Tree.BinarySearchTree;

import java.util.Scanner;

public class BinarySearchTreeInsertion {
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

    private void inorderTraversal(Node currentNode) {
        if(currentNode != null) {
            inorderTraversal(currentNode.leftChild);
            System.out.print(currentNode.data + " ");
            inorderTraversal(currentNode.rightChild);
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

    public static void main(String[] args) {
        BinarySearchTreeInsertion binarySearchTreeInsertion
                = new BinarySearchTreeInsertion();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number of nodes required: ");
        int numberOfNodes = scanner.nextInt();

        for(int i = 1; i <= numberOfNodes; i++) {
            System.out.print("Please enter the data for node #" + i + ": ");
            int data = scanner.nextInt();

            binarySearchTreeInsertion.rootNode = binarySearchTreeInsertion.insertNode(binarySearchTreeInsertion.rootNode,data);
        }

        System.out.println("Inorder Traversal of the created tree: ");
        binarySearchTreeInsertion.inorderTraversal(binarySearchTreeInsertion.rootNode);
    }
}
