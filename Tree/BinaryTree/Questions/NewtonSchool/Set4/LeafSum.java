package Tree.BinaryTree.Questions.NewtonSchool.Set4;

public class LeafSum {
    class TreeNode {
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
    
    public int leafSum(TreeNode root){
        int sum = 0;
        if(root != null) {
            if(root.left == null && root.right == null) {
                sum = sum + root.val;
            }
            sum = sum + leafSum(root.left);
            sum = sum + leafSum(root.right);
        }
        return sum;
    }
}
