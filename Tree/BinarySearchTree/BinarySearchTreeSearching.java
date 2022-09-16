package Tree.BinarySearchTree;

import java.util.Scanner;

public class BinarySearchTreeSearching {
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

    private Node searchData(Node currentNode, int key) {
        if(currentNode == null) {
            return null;
        }

        if(currentNode.data == key) {
            return currentNode;
        }

        if(key < currentNode.data) {
            return searchData(currentNode.leftChild, key);
        }
        else {
            return searchData(currentNode.rightChild, key);
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeSearching binarySearchTreeSearching
                = new BinarySearchTreeSearching();

        Scanner scanner = new Scanner(System.in);


        int numberOfNodes = 10;

        for(int i = 1; i <= numberOfNodes; i++) {
            int data = (int)((Math.random() * 20) + 10);

            System.out.println("Inserting " + data + "...");
            binarySearchTreeSearching.rootNode = binarySearchTreeSearching.insertNode(binarySearchTreeSearching.rootNode,data);
        }

        System.out.println("Root of the tree: " + binarySearchTreeSearching.rootNode.data);

        System.out.print("Nodes: ");
        binarySearchTreeSearching.inorderTraversal(binarySearchTreeSearching.rootNode);

        System.out.println();

        System.out.print("Please enter the number to be searched: ");
        int key = scanner.nextInt();

        Node searchResult = binarySearchTreeSearching.searchData(binarySearchTreeSearching.rootNode, key);

        if(searchResult != null) {
            System.out.println(key + " found");
        }
        else {
            System.out.println(key + " not found");
        }
    }
}
