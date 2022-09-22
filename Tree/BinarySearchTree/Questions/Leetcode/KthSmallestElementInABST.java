/*
Leetcode Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
 */

package Tree.BinarySearchTree.Questions.Leetcode;

public class KthSmallestElementInABST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int result;
    int count;

    private void kthSmallestHelper(TreeNode currentNode, int k) {
        if(currentNode != null) {
            kthSmallestHelper(currentNode.left, k);
            count++;

            if(count == k) {
                result = currentNode.val;
                return;
            }

            if(count < k) {
                kthSmallestHelper(currentNode.right, k);
            }
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        count = 0;

        kthSmallestHelper(root, k);

        return result;
    }
}
