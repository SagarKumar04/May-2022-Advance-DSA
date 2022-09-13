package Tree.BinaryTree.Questions.NewtonSchool.Set1;

import java.util.Scanner;

public class QueryOnTree {
    int leftChild[];
    int rightChild[];
    int data[];

    private void performQuery1(int u, int x) {
        if(u == -1) {
            return;
        }

        data[u] = data[u] + x;
        performQuery1(leftChild[u], x);
        performQuery1(rightChild[u], x);
    }

    public static void main(String[] args) {
        QueryOnTree queryOnTree = new QueryOnTree();

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int Q = scanner.nextInt();

        queryOnTree.leftChild = new int[N + 1];
        queryOnTree.rightChild = new int[N + 1];
        queryOnTree.data = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            queryOnTree.leftChild[i] = scanner.nextInt();
            queryOnTree.rightChild[i] = scanner.nextInt();
        }

        for(int i = 1; i <= Q; i++) {
            int q = scanner.nextInt();

            int u = scanner.nextInt();

            //1 u x - add x to all nodes in subtree of node u
            if(q == 1) {
                int x = scanner.nextInt();
                queryOnTree.performQuery1(u, x);
            }
            //2 u - print the value of node u
            else {
                System.out.println(queryOnTree.data[u]);
            }
        }
    }
}
