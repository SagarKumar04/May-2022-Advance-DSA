package Tree.BinaryTree.ConstructionOfTreeUsingTraversal;

public class InorderPreorder {
    int preorderIndex;

    static class Node {
        Node leftChild;
        char data;
        Node rightChild;

        Node(char data) {
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

    private void preorderTraversal(Node rootNode) {
        if(rootNode != null) {
            System.out.print(rootNode.data + " ");
            preorderTraversal(rootNode.leftChild);
            preorderTraversal(rootNode.rightChild);
        }
    }

    private int searchInInorder(char inorder[], int inorderStart, int inorderEnd, char key) {
        int position = -1;

        for(int i = inorderStart; i <= inorderEnd; i++) {
            if(inorder[i] == key) {
                position = i;
                break;
            }
        }

        return position;
    }
    
    private Node buildTreeUsingInorderAndPreorder(char inorder[],
                                                  char preorder[],
                                                  int inorderStart,
                                                  int inorderEnd) {
        if(inorderStart > inorderEnd) {
            return null;
        }

        char currentRootNodeData = preorder[preorderIndex];
        Node currentRootNode = new Node(currentRootNodeData);
        preorderIndex++;

        if(inorderStart == inorderEnd) {
            return currentRootNode;
        }

        int inorderIndex = searchInInorder(inorder, inorderStart, inorderEnd, currentRootNodeData);

        currentRootNode.leftChild = buildTreeUsingInorderAndPreorder(inorder, preorder, inorderStart, inorderIndex - 1);
        currentRootNode.rightChild = buildTreeUsingInorderAndPreorder(inorder, preorder, inorderIndex + 1, inorderEnd);

        return currentRootNode;
    }

    public static void main(String[] args) {
        char inorder[] = {'D', 'B', 'E', 'A', 'F', 'C'};
        char preorder[] = {'A', 'B', 'D', 'E', 'C', 'F'};
        int length = inorder.length;

        InorderPreorder inorderPreorder = new InorderPreorder();

        inorderPreorder.preorderIndex = 0;

        Node root = inorderPreorder.buildTreeUsingInorderAndPreorder(inorder,
                preorder, 0, length - 1);

        System.out.println("Inorder Traversal of built tree: ");
        inorderPreorder.inorderTraversal(root);

        System.out.println();

        System.out.println("Preorder Traversal of built tree: ");
        inorderPreorder.preorderTraversal(root);
    }
}
