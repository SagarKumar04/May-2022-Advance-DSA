package Tree.BinaryTree.Traversal;

import java.util.*;

public class PreInPostTraversal {
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

    class Pair {
        Node currentNode;
        int occurrenceCount;

        Pair(Node currentNode, int occurrenceCount) {
            this.currentNode = currentNode;
            this.occurrenceCount = occurrenceCount;
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

    private void printPreorder(Node currentRootNode, List<Integer> testPreorderList) {
        if(currentRootNode != null) {
            testPreorderList.add(currentRootNode.data);
            printPreorder(currentRootNode.leftChild, testPreorderList);
            printPreorder(currentRootNode.rightChild, testPreorderList);
        }
    }

    private void printInorder(Node currentRootNode, List<Integer> testInorderList) {
        if(currentRootNode != null) {
            printInorder(currentRootNode.leftChild, testInorderList);
            testInorderList.add(currentRootNode.data);
            printInorder(currentRootNode.rightChild, testInorderList);
        }
    }

    private void printPostorder(Node currentRootNode,  List<Integer> testPostorderList) {
        if(currentRootNode != null) {
            printPostorder(currentRootNode.leftChild, testPostorderList);
            printPostorder(currentRootNode.rightChild, testPostorderList);
            testPostorderList.add(currentRootNode.data);
        }
    }
    
    private boolean verifyOutput(List<Integer> preorderList,
                              List<Integer> inorderList,
                              List<Integer> postorderList,
                              List<Integer> testPreorderList,
                              List<Integer> testInorderList,
                              List<Integer> testPostorderList) {
        printPreorder(rootNode, testPreorderList);
        printInorder(rootNode, testInorderList);
        printPostorder(rootNode, testPostorderList);

        if(preorderList.equals(testPreorderList)
        && inorderList.equals(testInorderList)
        && postorderList.equals(testPostorderList)) {
            return true;
        }

        return false;
    }

    private void getPreInPostTraversalResult(List<Integer> preorderList,
                                             List<Integer> inorderList,
                                             List<Integer> postorderList) {
        if(rootNode == null) {
            return;
        }

        Stack<Pair> pairStack = new Stack<>();
        pairStack.push(new Pair(rootNode, 1));

        while(!pairStack.isEmpty()) {
            Pair topPair = pairStack.pop();

            if(topPair.occurrenceCount == 1) {
                preorderList.add(topPair.currentNode.data);
                topPair.occurrenceCount++;
                pairStack.push(topPair);

                if(topPair.currentNode.leftChild != null) {
                    pairStack.push(new Pair(topPair.currentNode.leftChild, 1));
                }
            }
            else if(topPair.occurrenceCount == 2) {
                inorderList.add(topPair.currentNode.data);
                topPair.occurrenceCount++;
                pairStack.push(topPair);

                if(topPair.currentNode.rightChild != null) {
                    pairStack.push(new Pair(topPair.currentNode.rightChild, 1));
                }
            }
            else {
                postorderList.add(topPair.currentNode.data);
            }
        }
    }

    public static void main(String[] args) {
        PreInPostTraversal preInPostTraversal = new PreInPostTraversal();

        for(int i = 0; i < 10; i++) {
            int randomNumber = (int)(Math.random() * 100); //range -> 0 to 99

            System.out.println("Inserting " + randomNumber + " in the tree...");
            preInPostTraversal.insertNode(randomNumber);
        }

        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();

        preInPostTraversal.getPreInPostTraversalResult(
                preorderList,
                inorderList,
                postorderList
        );

        List<Integer> testPreorderList = new ArrayList<>();
        List<Integer> testInorderList = new ArrayList<>();
        List<Integer> testPostorderList = new ArrayList<>();

        boolean isCorrect = preInPostTraversal.verifyOutput(
                preorderList,
                inorderList,
                postorderList,
                testPreorderList,
                testInorderList,
                testPostorderList
        );

        if(isCorrect) {
            System.out.println("Preorder: " + preorderList);
            System.out.println("Inorder: " + inorderList);
            System.out.println("Postorder: " + postorderList);
        }
        else {
            System.out.println("Test failed! Error in logic.");
        }
    }
}
