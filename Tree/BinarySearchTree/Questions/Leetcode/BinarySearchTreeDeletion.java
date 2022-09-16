package Tree.BinarySearchTree.Questions.Leetcode;

import Tree.BinarySearchTree.BinarySearchTreeSearching;

import java.util.Scanner;

public class BinarySearchTreeDeletion {
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

    private int inorderSuccessor(Node currentNode) {
        int minimumValue = currentNode.data;

        while(currentNode.leftChild != null) {
            minimumValue = currentNode.leftChild.data;
            currentNode = currentNode.leftChild;
        }

        return minimumValue;
    }

    private Node deleteNodeHelper(Node currentNode, int deleteNode) {
        if(currentNode == null) {
            return null;
        }

        if(deleteNode < currentNode.data) {
            /*
            The code was not working as expected because the return value of the
            deleteNodeHelper() method was not being initialized to the variable
            leftChild of currentNode
             */
            currentNode.leftChild = deleteNodeHelper(currentNode.leftChild, deleteNode);
        }
        else if(deleteNode > currentNode.data) {
            /*
            The code was not working as expected because the return value of the
            deleteNodeHelper() method was not being initialized to the variable
            rightChild of currentNode
             */
            currentNode.rightChild = deleteNodeHelper(currentNode.rightChild, deleteNode);
        }
        else {
            if(currentNode.leftChild == null) {
                return currentNode.rightChild;
            }
            else if(currentNode.rightChild == null) {
                return currentNode.leftChild;
            }
            else {
                int minimumValue = inorderSuccessor(currentNode.rightChild);
                currentNode.data = minimumValue;

                currentNode.rightChild = deleteNodeHelper(currentNode.rightChild, currentNode.data);
            }
        }

        return currentNode;
    }

    private void deleteNode(int deleteNode) {
        deleteNodeHelper(rootNode, deleteNode);
    }

    public static void main(String[] args) {
        BinarySearchTreeDeletion binarySearchTreeDeletion
                = new BinarySearchTreeDeletion();

        Scanner scanner = new Scanner(System.in);

        int numberOfNodes = 10;

        for(int i = 1; i <= numberOfNodes; i++) {
            int data = (int)((Math.random() * 100) + 10);

            System.out.println("Inserting " + data + "...");
            binarySearchTreeDeletion.rootNode = binarySearchTreeDeletion.insertNode(binarySearchTreeDeletion.rootNode,data);
        }

        System.out.println("Root of the tree: " + binarySearchTreeDeletion.rootNode.data);

        System.out.print("Nodes: ");
        binarySearchTreeDeletion.inorderTraversal(binarySearchTreeDeletion.rootNode);

        System.out.println();

        System.out.println("Please enter the node's value to be deleted: ");
        int deleteNode = scanner.nextInt();

        binarySearchTreeDeletion.deleteNode(deleteNode);

        System.out.print("Nodes: ");
        binarySearchTreeDeletion.inorderTraversal(binarySearchTreeDeletion.rootNode);
    }
}
