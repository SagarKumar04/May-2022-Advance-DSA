/*
Leetcode Link: https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
 */

package Tree.BinarySearchTree.Questions.Leetcode;

public class MaximumSumBSTInBinaryTree {
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
    
    int maximumSum = 0;

    static class NodeWrapper {
        TreeNode node;
        boolean isValidBST;
        int minimum;
        int maximum;
        int sum;

        NodeWrapper(TreeNode node) {
            this.node = node;
            this.isValidBST = true;
            this.minimum = node.val;
            this.maximum = node.val;
            this.sum = node.val;
        }
    }

    private NodeWrapper maxSumBSTHelper(TreeNode currentNode) {
        if(currentNode == null) {
            return null;
        }

        NodeWrapper leftSubtree = maxSumBSTHelper(currentNode.left);
        NodeWrapper rightSubtree = maxSumBSTHelper(currentNode.right);

        NodeWrapper currentNodeWrapper = new NodeWrapper(currentNode);

        if(leftSubtree != null) {
            currentNodeWrapper.isValidBST = leftSubtree.isValidBST && currentNode.val > leftSubtree.maximum;
            currentNodeWrapper.minimum = Math.min(leftSubtree.minimum, currentNode.val);
            currentNodeWrapper.maximum = Math.max(leftSubtree.maximum, currentNode.val);
            currentNodeWrapper.sum += leftSubtree.sum;

        }

        if(rightSubtree != null) {
            currentNodeWrapper.isValidBST =  (currentNodeWrapper.isValidBST) && (rightSubtree.isValidBST && currentNode.val < rightSubtree.minimum);
            currentNodeWrapper.minimum = Math.min(currentNodeWrapper.minimum, rightSubtree.minimum);
            currentNodeWrapper.maximum = Math.max(currentNodeWrapper.maximum, rightSubtree.maximum);
            currentNodeWrapper.sum += rightSubtree.sum;
        }

        if(currentNodeWrapper.isValidBST) {
            maximumSum = Math.max(maximumSum, currentNodeWrapper.sum);
        }

        return currentNodeWrapper;
    }

    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);

        return maximumSum;
    }
}
