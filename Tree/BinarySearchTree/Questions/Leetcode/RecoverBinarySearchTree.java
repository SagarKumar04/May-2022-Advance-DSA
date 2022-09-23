/*
Leetcode Link: https://leetcode.com/problems/recover-binary-search-tree/
 */

package Tree.BinarySearchTree.Questions.Leetcode;

public class RecoverBinarySearchTree {
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

    TreeNode firstNode = null;
    TreeNode secondNode = null;

    TreeNode previousElement = new TreeNode(Integer.MIN_VALUE);

    private void recoverTreeHelper(TreeNode currentNode) {
        if(currentNode != null) {
            recoverTreeHelper(currentNode.left);

            //process
            if(firstNode == null && previousElement.val > currentNode.val) {
                firstNode = previousElement;
            }

            if(firstNode != null && previousElement.val > currentNode.val) {
                secondNode = currentNode;
            }

            previousElement = currentNode;

            recoverTreeHelper(currentNode.right);
        }
    }

    public void recoverTree(TreeNode root) {
        recoverTreeHelper(root);

        //swap
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
}
