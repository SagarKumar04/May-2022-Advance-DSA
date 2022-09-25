package Tree.BinaryTree.Questions.NewtonSchool.Set5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateByRaja {
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

    Set<Integer> hs = new HashSet<>();
    List<Integer> list = new ArrayList<>();

    public boolean duplicate(TreeNode root){
        if (root == null) {
            return false;
        }

        list.add(root.val);
        hs.add(root.val);

        duplicate(root.left);
        duplicate(root.right);

        if (list.size() > hs.size()) {
            return true;
        }
        else {
            return false;
        }
    }
}
