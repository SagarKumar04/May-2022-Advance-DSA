package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {
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

    private int getHeightOfBinaryTree(Node currentNode) {
        if(currentNode == null) {
            return -1;
        }
        int leftHeight = getHeightOfBinaryTree(currentNode.leftChild);
        int rightHeight = getHeightOfBinaryTree(currentNode.rightChild);

        return (Math.max(leftHeight, rightHeight) + 1);
    }

    public static void main(String[] args) {
        HeightOfBinaryTree heightOfBinaryTree
                = new HeightOfBinaryTree();

        for(int i = 0; i < 30; i++) {
            int randomNumber = (int)(Math.random() * 100); //range -> 0 to 99
            heightOfBinaryTree.insertNode(randomNumber);
        }

        int height = heightOfBinaryTree
                .getHeightOfBinaryTree(heightOfBinaryTree.rootNode);

        System.out.print("Height of the Binary Tree: " + height);
    }
}
