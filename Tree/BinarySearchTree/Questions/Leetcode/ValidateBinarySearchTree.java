/*
Leetcode Link: https://leetcode.com/problems/validate-binary-search-tree/
 */

package Tree.BinarySearchTree.Questions.Leetcode;

public class ValidateBinarySearchTree {
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
    
    private boolean isValidBSTHelper(TreeNode currentNode, Integer min, Integer max) {
        boolean leftStatus = true;
        boolean rightStatus = true;

        if(currentNode != null) {
            if(min != null && currentNode.val <= min) {
                return false;
            }

            if(max != null && currentNode.val >= max) {
                return false;
            }

            leftStatus = isValidBSTHelper(currentNode.left, min, currentNode.val);
            rightStatus = isValidBSTHelper(currentNode.right, currentNode.val, max);
        }

        return (leftStatus && rightStatus);
    }

    public boolean isValidBST(TreeNode root) {
        boolean result = isValidBSTHelper(root, null, null);

        return result;
    }
}
