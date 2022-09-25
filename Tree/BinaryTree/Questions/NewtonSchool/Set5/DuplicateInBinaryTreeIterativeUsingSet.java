package Tree.BinaryTree.Questions.NewtonSchool.Set5;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DuplicateInBinaryTreeIterativeUsingSet {
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

    public boolean duplicate(TreeNode root) {
        if(root != null) {
            Set<Integer> values = new HashSet<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                int val = temp.val;

                if(values.contains(val)) {
                    return true;
                }
                values.add(val);

                if(temp.left != null) {
                    queue.add(temp.left);
                }

                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }

        return false;
    }
}
