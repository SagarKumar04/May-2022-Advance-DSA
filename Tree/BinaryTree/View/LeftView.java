package Tree.BinaryTree.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {
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

    private void getLeftView(Node currentNode,
                              int levelNumber,
                              List<Integer> leftViewList) {
        if(currentNode == null) {
            return;
        }

        if(levelNumber == leftViewList.size()) {
            leftViewList.add(currentNode.data);
        }

        getLeftView(currentNode.leftChild, levelNumber + 1, leftViewList);
        getLeftView(currentNode.rightChild, levelNumber + 1, leftViewList);
    }

    public static void main(String[] args) {
        LeftView leftView = new LeftView();

        for(int i = 0; i < 10; i++) {
            int randomNumber = (int)(Math.random() * 100); //range -> 0 to 99

            System.out.println("Inserting " + randomNumber + "...");
            leftView.insertNode(randomNumber);
        }

        List<Integer> leftViewList = new ArrayList<>();

        leftView.getLeftView(
                leftView.rootNode,
                0,
                leftViewList
        );
        System.out.println("Left View: " + leftViewList);
    }
}
