package Tree.BinaryTree.Questions.NewtonSchool.Set5;

import java.util.*;

public class DuplicateInBinaryTreeIterativeUsingMap {
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

    public boolean duplicate(TreeNode root){
        if(root != null) {
            Map<Integer, Integer> values = new HashMap<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                int val = temp.val;

                if(values.containsKey(val)) {
                    return true;
                }
                values.put(val, 1);

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
