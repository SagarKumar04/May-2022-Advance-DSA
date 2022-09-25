package Tree.BinarySearchTree.Questions.NewtonSchool.Set1;

class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

public class InsertionInBST {
    static Node insertInBST(Node root, int key) {
        // Your code here
        if(root == null) {
            Node newNode = new Node(key);
            root = newNode;
        }
        else {
            if(key < root.data) {
                root.left = insertInBST(root.left, key);
            }
            else if(key > root.data) {
                root.right = insertInBST(root.right, key);
            }
            else {

            }
        }

        return root;
    }
}
