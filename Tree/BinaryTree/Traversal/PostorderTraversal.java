/*
Leetcode Link: https://leetcode.com/problems/binary-tree-postorder-traversal/
 */

package Tree.BinaryTree.Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class PostorderTraversal {
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

    private void printPostorder(Node currentRootNode) {
        if(currentRootNode != null) {
            printPostorder(currentRootNode.leftChild);
            printPostorder(currentRootNode.rightChild);
            System.out.print(currentRootNode.data + " ");
        }
    }

    public static void main(String[] args) {
        PostorderTraversal postorderTraversal
                = new PostorderTraversal();

        for(int i = 0; i < 10; i++) {
            int randomNumber = (int)(Math.random() * 100); //range -> 0 to 99

            System.out.println("Inserting " + randomNumber + " in the tree...");
            postorderTraversal.insertNode(randomNumber);
        }

        System.out.println();
        System.out.println("Inorder: ");
        postorderTraversal.printPostorder(postorderTraversal.rootNode);
        System.out.println();
    }
}
