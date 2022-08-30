package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalRecursive {
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

    private int getHeightOfBinaryTree(Node currentNode) {
        if(currentNode == null) {
            return -1;
        }
        int leftHeight = getHeightOfBinaryTree(currentNode.leftChild);
        int rightHeight = getHeightOfBinaryTree(currentNode.rightChild);

        return (Math.max(leftHeight, rightHeight) + 1);
    }

    private void printCurrentLevel(Node currentNode, int levelNumber) {
        if(currentNode == null) {
            return;
        }

        if(levelNumber == 0) {
            System.out.print(currentNode.data + " ");
        }
        else {
            printCurrentLevel(currentNode.leftChild, levelNumber - 1);
            printCurrentLevel(currentNode.rightChild, levelNumber - 1);
        }
    }

    private void printTreeRecursiveLevelOrder() {
        int heightOfTree = getHeightOfBinaryTree(rootNode);

        for(int i = 0; i <= heightOfTree; i++) {
            printCurrentLevel(rootNode, i);
        }
    }

    private void insertNode(int data) {
        Node newNode = new Node(data);

        //first node of the tree
        if(rootNode == null) {
            rootNode = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);

        Node temp;
        while(!queue.isEmpty()) {
            temp = queue.poll();

            if(temp.leftChild == null) {
                temp.leftChild = newNode;
                break;
            }
            else {
                queue.add(temp.leftChild);
            }

            if(temp.rightChild == null) {
                temp.rightChild = newNode;
                break;
            }
            else {
                queue.add(temp.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversalRecursive levelOrderTraversalRecursive
                = new LevelOrderTraversalRecursive();

        for(int i = 0; i < 10; i++) {
            int randomNumber = (int)(Math.random() * 100); //range -> 0 to 99

            System.out.println("Inserting " + randomNumber + " in the tree...");
            levelOrderTraversalRecursive.insertNode(randomNumber);
        }

        System.out.println();

        System.out.println("Current Tree: ");
        levelOrderTraversalRecursive.printTreeRecursiveLevelOrder();
    }
}
