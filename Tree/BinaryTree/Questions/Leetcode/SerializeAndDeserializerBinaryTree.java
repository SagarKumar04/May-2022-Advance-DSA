/*
Leetcode Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */

package Tree.BinaryTree.Questions.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializerBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private final String delimiter = ",";
    private final String NULL_NODE = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if(currentNode == null) {
                stringBuilder.append(NULL_NODE).append(delimiter);
            }
            else {
                stringBuilder.append(currentNode.val).append(delimiter);
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }

        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") {
            return null;
        }

        String dataArray[] = data.split(delimiter);
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for(int i = 1; i < dataArray.length; i++) {
            TreeNode currentNode = queue.poll();

            if(!dataArray[i].equals(NULL_NODE)) {
                TreeNode leftChild = new TreeNode(Integer.parseInt(dataArray[i]));
                currentNode.left = leftChild;

                queue.add(leftChild);
            }

            if(!dataArray[++i].equals(NULL_NODE)) {
                TreeNode rightChild = new TreeNode(Integer.parseInt(dataArray[i]));
                currentNode.right = rightChild;

                queue.add(rightChild);
            }
        }

        return root;
    }
}
