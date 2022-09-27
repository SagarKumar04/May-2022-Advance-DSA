package Tree.BinarySearchTree.Questions.NewtonSchool.Set3;

import java.util.Scanner;

public class CountNodes {
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

    private int countNodes(Node currentRootNode, int low, int high) {
        if(currentRootNode == null) {
            return 0;
        }

        if(currentRootNode.data < low) {
            //go for right subtree only
            return countNodes(currentRootNode.rightChild, low, high);
        }

        if(currentRootNode.data > high) {
            //go for left subtree only
            return countNodes(currentRootNode.leftChild, low, high);
        }

        //go for both the left subtree and the right subtree only
        return (1 + countNodes(currentRootNode.rightChild, low, high)
                + countNodes(currentRootNode.leftChild, low, high));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        
        int N = scanner.nextInt();

        CountNodes countNodes = new CountNodes();
        for(int i = 1; i <= N; i++) {
            int data = scanner.nextInt();

            countNodes.rootNode = countNodes.insertNode(countNodes.rootNode,data);
        }

        int count = countNodes.countNodes(countNodes.rootNode, low, high);

        System.out.println(count);
    }
}
