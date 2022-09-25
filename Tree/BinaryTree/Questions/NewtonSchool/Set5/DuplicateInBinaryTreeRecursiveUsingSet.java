package Tree.BinaryTree.Questions.NewtonSchool.Set5;

import java.util.HashSet;
import java.util.Set;

public class DuplicateInBinaryTreeRecursiveUsingSet {
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

    Set<Integer> values = new HashSet<>();

    public boolean duplicate(TreeNode root){
        if(root != null) {
            if(values.contains(root.val)) {
                return true;
            }

            values.add(root.val);

            return duplicate(root.left) || duplicate(root.right);
        }

        return false;
    }
}
