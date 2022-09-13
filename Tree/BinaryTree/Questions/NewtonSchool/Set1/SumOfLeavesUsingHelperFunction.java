package Tree.BinaryTree.Questions.NewtonSchool.Set1;

public class SumOfLeavesUsingHelperFunction {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static int sum;

    private static void sumOfLeafHelper(Node currentNode) {
        if(currentNode == null) {
            return;
        }

        if(currentNode.left == null && currentNode.right == null) {
            sum += currentNode.data;
        }

        sumOfLeafHelper(currentNode.left);
        sumOfLeafHelper(currentNode.right);
    }

    public static int sumOfLeaf(Node root) {
        // Your code here
        sum = 0;

        sumOfLeafHelper(root);

        return sum;
    }
}
