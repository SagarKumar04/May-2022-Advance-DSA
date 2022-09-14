package Tree.BinaryTree.Questions.NewtonSchool.Set2;

public class CountNumberOfSubtreesHavingGivenSum {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    static int count;

    static int countSubtreesWithSumXHelper(Node root, int x) {
        if(root == null) {
            return 0;
        }

        int leftSum = countSubtreesWithSumXHelper(root.left, x);
        int rightSum = countSubtreesWithSumXHelper(root.right, x);

        int sum = leftSum + root.data + rightSum;

        if(sum == x) {
            count++;
        }

        return sum;
    }

    static int countSubtreesWithSumX(Node root, int x) {
        // Your code here
        count = 0;

        int leftSum = countSubtreesWithSumXHelper(root.left, x);
        int rightSum = countSubtreesWithSumXHelper(root.right, x);

        if((leftSum + root.data + rightSum) == x) {
            count++;
        }

        return count;
    }
}
