package Tree.BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalIterative {
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

    /*
    Leetcode Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
     */
    private void storeTreeDataLevelWise() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        queue.add(null);

        List<List<Integer>> treeData = new ArrayList<>();
        List<Integer> currentLevelData = new ArrayList<>();

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp != null) {
                currentLevelData.add(temp.data);

                if(temp.leftChild != null) {
                    queue.add(temp.leftChild);
                }

                if(temp.rightChild != null) {
                    queue.add(temp.rightChild);
                }
            }
            else {
                List<Integer> tempList = new ArrayList<>(currentLevelData);

                treeData.add(tempList);
                currentLevelData.clear();

                if(!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }

        System.out.println("Tree Data: ");
        System.out.println(treeData);
    }

    private void printTreeLevelWise() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        queue.add(null);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp != null) {
                System.out.print(temp.data + " ");

                if(temp.leftChild != null) {
                    queue.add(temp.leftChild);
                }

                if(temp.rightChild != null) {
                    queue.add(temp.rightChild);
                }
            }
            else {
                System.out.println();

                if(!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
    }

    private void printTree() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");

            if(temp.leftChild != null) {
                queue.add(temp.leftChild);
            }

            if(temp.rightChild != null) {
                queue.add(temp.rightChild);
            }
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
        LevelOrderTraversalIterative levelOrderTraversalIterative
                = new LevelOrderTraversalIterative();

        for(int i = 0; i < 10; i++) {
            int randomNumber = (int)(Math.random() * 100); //range -> 0 to 99

            System.out.println("Inserting " + randomNumber + " in the tree...");
            levelOrderTraversalIterative.insertNode(randomNumber);
        }

        System.out.println();

        System.out.println("Current Tree: ");
        levelOrderTraversalIterative.printTree();
        levelOrderTraversalIterative.printTreeLevelWise();
        levelOrderTraversalIterative.storeTreeDataLevelWise();
    }
}
