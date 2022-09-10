package Tree.BinaryTree.Questions.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderTraversalUsingArrayList {
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

    TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> nodeMap;
    List<List<Integer>> result;

    //nodeMap: {-1={1=[9]}, 0={0=[3], 2=[15]}, 1={1=[20]}, 2={2=[7]}}
    //nodeMap.values(): [{1=[9]}, {0=[3], 2=[15]}, {1=[20]}, {2=[7]}]
    private void beautifyOutput() {
        for(TreeMap<Integer, ArrayList<Integer>> eachNodeMap : nodeMap.values()) {
            List<Integer> columnList = new ArrayList<>();

            for(ArrayList<Integer> eachNodeList : eachNodeMap.values()) {
                Collections.sort(eachNodeList);

                columnList.addAll(eachNodeList);
            }

            result.add(columnList);
        }
    }

    private void getVerticalTraversal(TreeNode currentNode, int column, int row) {
        if(currentNode != null) {
            if(!nodeMap.containsKey(column)) {
                nodeMap.put(column, new TreeMap<>());
            }

            if(!nodeMap.get(column).containsKey(row)) {
                nodeMap.get(column).put(row, new ArrayList<>());
            }

            nodeMap.get(column).get(row).add(currentNode.val);

            getVerticalTraversal(currentNode.left, column - 1, row + 1);
            getVerticalTraversal(currentNode.right, column + 1, row + 1);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        nodeMap = new TreeMap<>();

        result = new ArrayList<>();

        getVerticalTraversal(root, 0, 0);

        beautifyOutput();

        return result;
    }
}
