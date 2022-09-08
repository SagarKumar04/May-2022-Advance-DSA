package Tree.BinaryTree.ConstructionOfTreeUsingTraversal;

/*
This code constructs a Full Binary Tree only
 */

public class PostorderPreorder {
    int preorderIndex;

    static class Node {
        Node leftChild;
        int data;
        Node rightChild;

        Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }

    private void postorderTraversal(Node rootNode) {
        if(rootNode != null) {
            postorderTraversal(rootNode.leftChild);
            postorderTraversal(rootNode.rightChild);
            System.out.print(rootNode.data + " ");
        }
    }

    private void preorderTraversal(Node rootNode) {
        if(rootNode != null) {
            System.out.print(rootNode.data + " ");
            preorderTraversal(rootNode.leftChild);
            preorderTraversal(rootNode.rightChild);
        }
    }

    private int searchInPostorder(int postorder[], int start, int end, int key) {
        int position = -1;

        for(int i = start; i <= end; i++) {
            if(postorder[i] == key) {
                position = i;
                break;
            }
        }

        return position;
    }

    private Node buildTreeUsingPostorderAndPreorder(int postorder[],
                                                    int preorder[],
                                                    int postorderStart,
                                                    int postorderEnd,
                                                    int size) {
        if(preorderIndex >= size || postorderStart > postorderEnd) {
            return null;
        }

        int currentRootNodeData = preorder[preorderIndex];
        Node currentRootNode = new Node(currentRootNodeData);
        preorderIndex++;

        if(postorderStart == postorderEnd) {
            return currentRootNode;
        }

        /*
        Node currentRootNode = new Node(preorder[preorderIndex++]);
         */

        int postorderIndex = searchInPostorder(postorder, postorderStart, postorderEnd, preorder[preorderIndex]);

        currentRootNode.leftChild = buildTreeUsingPostorderAndPreorder(postorder, preorder,
                postorderStart, postorderIndex, size);
        currentRootNode.rightChild = buildTreeUsingPostorderAndPreorder(postorder, preorder,
                postorderIndex + 1, postorderEnd - 1, size);

        return currentRootNode;
    }
    
    public static void main(String[] args) {
        int postorder[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
        int preorder[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int length = postorder.length;

        PostorderPreorder postorderPreorder = new PostorderPreorder();

        postorderPreorder.preorderIndex = 0;

        Node root = postorderPreorder.buildTreeUsingPostorderAndPreorder(postorder, preorder,
                0, length - 1, length);
        
        System.out.println("Postorder Traversal of built tree: ");
        postorderPreorder.postorderTraversal(root);

        System.out.println();

        System.out.println("Preorder Traversal of built tree: ");
        postorderPreorder.preorderTraversal(root);
    }
}
