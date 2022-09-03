/*
Leetcode Link: https://leetcode.com/problems/balanced-binary-tree/
 */

package Tree.BinaryTree.Questions.Leetcode;

public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    private int isBalancedHelper(TreeNode currentNode) {
        if(currentNode == null) {
            return 0;
        }

        int leftHeight = isBalancedHelper(currentNode.left);
        if(leftHeight == -1) {
            return -1;
        }

        int rightHeight = isBalancedHelper(currentNode.right);
        if(rightHeight == -1) {
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return (Math.max(leftHeight, rightHeight) + 1);
    }

    public boolean isBalanced(TreeNode root) {
        int result = isBalancedHelper(root);

        if(result != -1) {
            return true;
        }
        else {
            return false;
        }

        /*
        The above code can be reduced to just one line:
        return (isBalancedHelper(root) != -1);
         */
    }
}
