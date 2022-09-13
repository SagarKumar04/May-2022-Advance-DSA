package Tree.BinaryTree.Questions.NewtonSchool.Set1;

public class SumOfLeavesWithoutUsingHelperFunction {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    public static int sumOfLeaf(Node root) {
        // Your code here
        int sum = 0;
        if(root != null) {
            if(root.left == null && root.right == null) {
                sum = sum + root.data;
            }
            sum = sum + sumOfLeaf(root.left);
            sum = sum + sumOfLeaf(root.right);
        }
        return sum;
    }
}
