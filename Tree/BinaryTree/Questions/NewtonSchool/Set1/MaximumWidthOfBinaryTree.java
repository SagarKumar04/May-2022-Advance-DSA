package Tree.BinaryTree.Questions.NewtonSchool.Set1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
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

    static int getMaxWidth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        int maxWidth = 0;
        List<Integer> currentLevelData = new ArrayList<>();

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp != null) {
                currentLevelData.add(temp.data);

                if(temp.left != null) {
                    queue.add(temp.left);
                }

                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
            else {
                int currentWidth = currentLevelData.size();

                maxWidth = Math.max(maxWidth, currentWidth);

                currentLevelData.clear();

                if(!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }

        return maxWidth;
    }
}
