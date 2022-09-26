package Tree.BinarySearchTree.Questions.NewtonSchool.Set1;

public class DeletionInBst {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    private static int inorderSuccessor(Node currentNode) {
        int minimumValue = currentNode.data;

        while(currentNode.left != null) {
            minimumValue = currentNode.left.data;
            currentNode = currentNode.left;
        }

        return minimumValue;
    }

    private static Node deleteNodeHelper(Node currentNode, int deleteNode) {
        if(currentNode == null) {
            return null;
        }

        if(deleteNode < currentNode.data) {
            currentNode.left = deleteNodeHelper(currentNode.left, deleteNode);
        }
        else if(deleteNode > currentNode.data) {
            currentNode.right = deleteNodeHelper(currentNode.right, deleteNode);
        }
        else {
            if(currentNode.left == null) {
                return currentNode.right;
            }
            if(currentNode.right == null) {
                return currentNode.left;
            }
            int minimumValue = inorderSuccessor(currentNode.right);
            currentNode.data = minimumValue;

            currentNode.right = deleteNodeHelper(currentNode.right, currentNode.data);
        }

        return currentNode;
    }

    public static Node deleteInBST(Node root, int value) {
        // Your code here
        return deleteNodeHelper(root, value);
    }
}
