package Tree.BinaryTree.ConstructionOfTreeUsingTraversal;

public class InorderPostorder {
    static class Node {
        Node leftChild;
        int data;
        Node rightChild;

        Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }

    private void inorderTraversal(Node rootNode) {
        if(rootNode != null) {
            inorderTraversal(rootNode.leftChild);
            System.out.print(rootNode.data + " ");
            inorderTraversal(rootNode.rightChild);
        }
    }

    private void postorderTraversal(Node rootNode) {
        if(rootNode != null) {
            postorderTraversal(rootNode.leftChild);
            postorderTraversal(rootNode.rightChild);
            System.out.print(rootNode.data + " ");
        }
    }

    private int searchInInorder(int inorder[], int inorderStart, int inorderEnd, int key) {
        int position = -1;

        for(int i = inorderStart; i <= inorderEnd; i++) {
            if(inorder[i] == key) {
                position = i;
                break;
            }
        }

        return position;
    }

    private Node buildTreeUsingInorderAndPostorder(int inorder[],
                                                   int postorder[],
                                                   int inorderStart,
                                                   int inorderEnd,
                                                   int postorderStart,
                                                   int postorderEnd) {
        if(inorderStart > inorderEnd) {
            return null;
        }

        int currentRootNodeData = postorder[postorderEnd];
        Node currentRootNode = new Node(currentRootNodeData);

        if(inorderStart == inorderEnd) {
            return currentRootNode;
        }

        int inorderIndex = searchInInorder(inorder, inorderStart, inorderEnd, currentRootNodeData);

        currentRootNode.rightChild = buildTreeUsingInorderAndPostorder(inorder, postorder,
                inorderIndex + 1, inorderEnd, , postorderEnd - 1);
    }
    
    public static void main(String[] args) {
        int inorder[] = {4, 8, 2, 5, 1, 6, 3, 7};
        int postorder[] = {8, 4, 5, 2, 6, 7, 3, 1};
        int length = inorder.length;
        
        InorderPostorder inorderPostorder = new InorderPostorder();
        
        Node root = inorderPostorder.buildTreeUsingInorderAndPostorder(inorder, postorder,
                0, length - 1, 0, length - 1);

        System.out.println("Inorder Traversal of built tree: ");
        inorderPostorder.inorderTraversal(root);

        System.out.println();

        System.out.println("Postorder Traversal of built tree: ");
        inorderPostorder.postorderTraversal(root);
    }
}
