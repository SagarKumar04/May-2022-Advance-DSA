package Tree.BinarySearchTree.Questions.NewtonSchool.Set2;

public class DeleteNodeInABST {
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

    private static int inorderSuccessor(TreeNode currentNode) {
        int minimumValue = currentNode.val;

        while(currentNode.left != null) {
            minimumValue = currentNode.left.val;
            currentNode = currentNode.left;
        }

        return minimumValue;
    }

    private static TreeNode deleteNodeHelper(TreeNode currentNode, int deleteNode) {
        if(currentNode == null) {
            return null;
        }

        if(deleteNode < currentNode.val) {
            currentNode.left = deleteNodeHelper(currentNode.left, deleteNode);
        }
        else if(deleteNode > currentNode.val) {
            currentNode.right = deleteNodeHelper(currentNode.right, deleteNode);
        }
        else {
            if(currentNode.left == null) {
                return currentNode.right;
            }
            if(currentNode.right == null) {
                return currentNode.left;
            }
            int minimumValue = inorderSuccessor(currentNode.right);
            currentNode.val = minimumValue;

            currentNode.right = deleteNodeHelper(currentNode.right, currentNode.val);
        }

        return currentNode;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        // your code here
        return deleteNodeHelper(root, key);
    }
}
