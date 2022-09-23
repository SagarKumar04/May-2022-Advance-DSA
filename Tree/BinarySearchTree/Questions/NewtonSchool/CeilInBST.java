package Tree.BinarySearchTree.Questions.NewtonSchool;

import java.util.Scanner;

public class CeilInBST {
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

    private int getCeilOfBST(Node currentNode, int X) {
        if(currentNode == null) {
            return -1;
        }

        if(currentNode.data == X) {
            return currentNode.data;
        }

        if(currentNode.data < X) {
            return getCeilOfBST(currentNode.rightChild, X);
        }

        int ceilInLeftSubtree = getCeilOfBST(currentNode.leftChild, X);

        return (
                Math.max(currentNode.data, ceilInLeftSubtree)
        );
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();

        CeilInBST ceilInBST = new CeilInBST();
        
        for(int i = 0; i < N; i++) {
            int data = scanner.nextInt();
            ceilInBST.rootNode = ceilInBST.insertNode(ceilInBST.rootNode, data);
        }
        
        int X = scanner.nextInt();

        int ceil = ceilInBST.getCeilOfBST(ceilInBST.rootNode, X);

        System.out.println(ceil);
    }
}
