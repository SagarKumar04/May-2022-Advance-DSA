package Tree.BinaryTree.View;

import java.util.*;

public class RightView {
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

    private void getRightView(Node currentNode,
                              int levelNumber,
                              List<Integer> rightViewList) {
        if(currentNode == null) {
            return;
        }

        if(levelNumber == rightViewList.size()) {
            rightViewList.add(currentNode.data);
        }

        getRightView(currentNode.rightChild, levelNumber + 1, rightViewList);
        getRightView(currentNode.leftChild, levelNumber + 1, rightViewList);
    }

    public static void main(String[] args) {
        RightView rightView = new RightView();

        for(int i = 0; i < 10; i++) {
            int randomNumber = (int)(Math.random() * 100); //range -> 0 to 99

            System.out.println("Inserting " + randomNumber + "...");
            rightView.insertNode(randomNumber);
        }

        List<Integer> rightViewList = new ArrayList<>();

        rightView.getRightView(
                rightView.rootNode,
                0,
                rightViewList
        );
        System.out.println("Right View: " + rightViewList);
    }
}
