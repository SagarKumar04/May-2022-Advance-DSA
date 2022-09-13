package Tree.BinaryTree.Questions.NewtonSchool.Set1;

public class FoldableOrNot {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    private static boolean isSymmetricHelper(Node leftChild, Node rightChild) {
        if(leftChild == null && rightChild == null) {
            return true;
        }

        if(leftChild == null || rightChild == null) {
            return false;
        }

        return (isSymmetricHelper(leftChild.left, rightChild.right)
                && isSymmetricHelper(leftChild.right, rightChild.left));
    }

    static boolean isFoldable(Node node) {
        // Your code here
        if(node == null) {
            return true;
        }

        return isSymmetricHelper(node.left, node.right);
    }
}
