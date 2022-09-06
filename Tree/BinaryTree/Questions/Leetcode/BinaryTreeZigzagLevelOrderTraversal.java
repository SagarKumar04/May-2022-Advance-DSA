package Tree.BinaryTree.Questions.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            boolean isZigZag = false;

            queue.add(root);

            while(!queue.isEmpty()) {
                List<Integer> currentLevel = new ArrayList<>();

                int queueSize = queue.size();

                for(int i = 0; i < queueSize; i++) {
                    TreeNode temp = queue.poll();

                    if(!isZigZag) {
                        currentLevel.add(temp.val);
                    }
                    else {
                        currentLevel.add(0, temp.val);
                    }

                    if(temp.left != null) {
                        queue.add(temp.left);
                    }

                    if(temp.right != null) {
                        queue.add(temp.right);
                    }
                }

                result.add(currentLevel);
                isZigZag = !isZigZag;
            }
        }

        return result;
    }
}
