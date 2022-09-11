/*
Leetcode Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */

package Tree.BinaryTree.Questions.Leetcode;

public class BinaryTreeMaximumPathSum {
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

    int maxValue;

    private int getMaxValue(TreeNode currentNode) {
        int nodeMax = 0;

        if(currentNode != null) {
            int leftMax = getMaxValue(currentNode.left);
            int rightMax = getMaxValue(currentNode.right);

            nodeMax = Math.max(leftMax, rightMax) + currentNode.val;

            maxValue = Math.max(maxValue, (leftMax + currentNode.val + rightMax));
        }

        nodeMax = Math.max(0, nodeMax);

        return nodeMax;
    }

    public int maxPathSum(TreeNode root) {
        maxValue = root.val;

        getMaxValue(root);

        return maxValue;
    }
}
