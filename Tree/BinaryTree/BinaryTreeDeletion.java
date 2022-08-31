package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeDeletion {
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

    private void deleteDeepestRightmostNode(Node deepestRightmostNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);

        Node temp;
        while(!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.rightChild != null) {
                if (temp.rightChild == deepestRightmostNode) {
                    temp.rightChild = null;
                    return;
                }
                else {
                    queue.add(temp.rightChild);
                }
            }

            if(temp.leftChild != null) {
                if(temp.leftChild == deepestRightmostNode) {
                    temp.leftChild = null;
                    return;
                }
                else {
                    queue.add(temp.leftChild);
                }
            }
        }
    }

    private void deleteNode(int data) {
        if(rootNode == null) {
            return;
        }

        if(rootNode.leftChild == null && rootNode.rightChild == null) {
            if(rootNode.data == data) {
                rootNode = null;
            }
            return;
        }

        Node deleteNode = null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        Node temp = null;

        while(!queue.isEmpty()) {
            temp = queue.poll();

            if(temp.data == data) {
                deleteNode = temp;
            }

            if(temp.leftChild != null) {
                queue.add(temp.leftChild);
            }

            if(temp.rightChild != null) {
                queue.add(temp.rightChild);
            }
        }

        if(deleteNode != null) {
            int lastNodeData = temp.data;
            //delete 'temp'
            deleteDeepestRightmostNode(temp);
            deleteNode.data = lastNodeData;
        }
    }

    public static void main(String[] args) {
        BinaryTreeDeletion binaryTreeDeletion
                = new BinaryTreeDeletion();

        List<Integer> nodeDataList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            int randomNumber = (int)(Math.random() * 100); //range -> 0 to 99

            nodeDataList.add(randomNumber);

            binaryTreeDeletion.insertNode(randomNumber);
        }
        System.out.println("Current Tree: ");
        binaryTreeDeletion.storeTreeDataLevelWise();
        System.out.println();

        System.out.println("Node to be deleted: " + nodeDataList.get(3));
        binaryTreeDeletion.deleteNode(nodeDataList.get(3));
        binaryTreeDeletion.storeTreeDataLevelWise();
    }
}
