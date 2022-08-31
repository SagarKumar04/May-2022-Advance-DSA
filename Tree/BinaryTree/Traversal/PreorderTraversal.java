/*
Leetcode Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
 */

package Tree.BinaryTree.Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class PreorderTraversal {
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

    private void printPreorder(Node currentRootNode) {
        if(currentRootNode != null) {
            System.out.print(currentRootNode.data + " ");
            printPreorder(currentRootNode.leftChild);
            printPreorder(currentRootNode.rightChild);
        }
    }

    public static void main(String[] args) {
        PreorderTraversal preorderTraversal
                = new PreorderTraversal();

        for(int i = 0; i < 10; i++) {
            int randomNumber = (int)(Math.random() * 100); //range -> 0 to 99

            System.out.println("Inserting " + randomNumber + " in the tree...");
            preorderTraversal.insertNode(randomNumber);
        }

        System.out.println();
        System.out.println("Preorder: ");
        preorderTraversal.printPreorder(preorderTraversal.rootNode);
        System.out.println();
    }
}
