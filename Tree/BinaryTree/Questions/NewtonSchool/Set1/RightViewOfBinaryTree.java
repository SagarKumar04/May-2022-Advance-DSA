package Tree.BinaryTree.Questions.NewtonSchool.Set1;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBinaryTree {
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

    private static void getRightView(Node currentNode,
                                     int levelNumber,
                                     List<Integer> rightViewList) {
        if(currentNode == null) {
            return;
        }

        if(levelNumber == rightViewList.size()) {
            rightViewList.add(currentNode.data);
        }

        getRightView(currentNode.right, levelNumber + 1, rightViewList);
        getRightView(currentNode.left, levelNumber + 1, rightViewList);
    }

    static void printRightView(Node node) {
        List<Integer> rightViewList = new ArrayList<>();

        getRightView(
                node,
                0,
                rightViewList
        );

        for(Integer value : rightViewList) {
            System.out.print(value + " ");
        }
    }
}
