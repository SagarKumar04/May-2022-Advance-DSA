/*
Leetcode Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */

package Tree.BinarySearchTree.Questions.Leetcode;

import java.util.HashSet;

public class TwoSumIV {
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

 private boolean findTargetHelper(TreeNode currentNode, int k, HashSet<Integer> data) {
  if(currentNode == null) {
   return false;
  }

  if(data.contains(k - currentNode.val)) {
   return true;
  }

  data.add(currentNode.val);

  boolean leftStatus = findTargetHelper(currentNode.left, k, data);
  boolean rightStatus = findTargetHelper(currentNode.right, k, data);

  return (leftStatus || rightStatus);
 }

 public boolean findTarget(TreeNode root, int k) {
  HashSet<Integer> data = new HashSet<>();

  return findTargetHelper(root, k, data);
 }
}
