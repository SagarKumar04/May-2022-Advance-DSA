/*
Leetcode Link: https://leetcode.com/problems/diameter-of-binary-tree/
 */

package Tree.BinaryTree.Questions.Leetcode;

public class DiameterOfBinaryTree {
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

    int diameter = 0;

    private int getHeight(TreeNode currentNode) {
        int height = 0;

        if(currentNode != null) {
            int leftHeight = getHeight(currentNode.left);
            int rightHeight = getHeight(currentNode.right);

            height = Math.max(leftHeight, rightHeight) + 1;

            diameter = Math.max(diameter, leftHeight + rightHeight);
        }

        return height;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);

        return diameter;
    }
}
