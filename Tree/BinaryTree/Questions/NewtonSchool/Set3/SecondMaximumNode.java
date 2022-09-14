package Tree.BinaryTree.Questions.NewtonSchool.Set3;

public class SecondMaximumNode {
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

    class Result {
        int highest;
        int secondHighest;

        Result() {
            highest = -1;
            secondHighest = -1;
        }
    }

    private void preorderTraversal(TreeNode currentNode, Result result) {
        if(currentNode == null) {
            return;
        }

        if(currentNode.val > result.highest) {
            result.secondHighest = result.highest;
            result.highest = currentNode.val;
        }
        else if(currentNode.val > result.secondHighest) {
            result.secondHighest = currentNode.val;
        }
        else {

        }

        preorderTraversal(currentNode.left, result);
        preorderTraversal(currentNode.right, result);
    }

    public int SecondMaxNode(TreeNode root){
        Result result = new Result();

        preorderTraversal(root, result);

        return (
                (result.secondHighest != -1) ? (result.secondHighest) : (result.highest)
        );
    }
}
