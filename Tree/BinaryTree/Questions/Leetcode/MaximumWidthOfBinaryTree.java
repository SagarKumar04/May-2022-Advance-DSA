/*
Leetcode Link: https://leetcode.com/problems/maximum-width-of-binary-tree/
 */

package Tree.BinaryTree.Questions.Leetcode;

import java.util.ArrayDeque;

public class MaximumWidthOfBinaryTree {
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

    class Pair {
        TreeNode currentNode;
        int arrayIndex;

        Pair(TreeNode currentNode, int arrayIndex) {
            this.currentNode = currentNode;
            this.arrayIndex = arrayIndex;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        
        Pair rootNode = new Pair(root, 0);
        ArrayDeque<Pair> levelDequeue = new ArrayDeque<>();

        levelDequeue.add(rootNode);

        while(!levelDequeue.isEmpty()) {
            int size = levelDequeue.size();

            int indexOfLastNode = levelDequeue.getLast().arrayIndex;
            int indexOfFirstNode = levelDequeue.getFirst().arrayIndex;

            int currentWidth = indexOfLastNode - indexOfFirstNode + 1;

            maxWidth = Math.max(maxWidth, currentWidth);

            for(int i = 0; i < size; i++) {
                Pair firstNode = levelDequeue.poll();
                TreeNode key = firstNode.currentNode;
                int value = firstNode.arrayIndex;

                if(key.left != null) {
                    int leftChildIndex = 2 * value + 1;
                    Pair pair = new Pair(key.left, leftChildIndex);
                    levelDequeue.add(pair);
                }

                if(key.right != null) {
                    int rightChildIndex = 2 * value + 2;
                    Pair pair = new Pair(key.right, rightChildIndex);
                    levelDequeue.add(pair);
                }
            }
        }
        
        return maxWidth;
    }
}
