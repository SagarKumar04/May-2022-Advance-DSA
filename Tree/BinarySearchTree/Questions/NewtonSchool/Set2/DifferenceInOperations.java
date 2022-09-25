package Tree.BinarySearchTree.Questions.NewtonSchool.Set2;

import java.util.Scanner;

public class DifferenceInOperations {
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

    private int getMinimumInBST(Node currentNode) {
        int minimumValue = currentNode.data;

        while(currentNode.leftChild != null) {
            minimumValue = currentNode.leftChild.data;
            currentNode = currentNode.leftChild;
        }

        return minimumValue;
    }

    private int getMaximumInBST(Node currentNode) {
        int maximumValue = currentNode.data;

        while(currentNode.rightChild != null) {
            maximumValue = currentNode.rightChild.data;
            currentNode = currentNode.rightChild;
        }

        return maximumValue;
    }
    
    public static void main (String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        DifferenceInOperations differenceInOperations = new DifferenceInOperations();

        for(int i = 0; i < n; i++) {
            int data = scanner.nextInt();

            differenceInOperations.rootNode = differenceInOperations.insertNode(differenceInOperations.rootNode,data);
        }

        int minimum = differenceInOperations.getMinimumInBST(differenceInOperations.rootNode);
        int maximum = differenceInOperations.getMaximumInBST(differenceInOperations.rootNode);

        System.out.println((minimum * maximum) - (minimum + maximum));
    }
}
