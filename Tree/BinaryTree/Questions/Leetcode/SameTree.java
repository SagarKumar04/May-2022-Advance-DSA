package Tree.BinaryTree.Questions.Leetcode;

public class SameTree {
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
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }

        if(p.val == q.val) {
            boolean leftStatus = isSameTree(p.left, q.left);
            boolean rightStatus = isSameTree(p.right, q.right);

            return (leftStatus && rightStatus);
        }

        return false;
    }
}
