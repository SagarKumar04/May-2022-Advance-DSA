package Tree.BinaryTree.Questions.NewtonSchool.Set2;

public class HeightOfBinaryTree {
    class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static int getHeightOfBinaryTree(Node currentNode) {
        if(currentNode == null) {
            return 0;
        }
        int leftHeight = getHeightOfBinaryTree(currentNode.left);
        int rightHeight = getHeightOfBinaryTree(currentNode.right);

        return (Math.max(leftHeight, rightHeight) + 1);
    }

    static int getHeight(Node node) {
        // Your code here
        int height = getHeightOfBinaryTree(node);

        return height;
    }
}
