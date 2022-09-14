package Tree.BinaryTree.Questions.NewtonSchool.Set2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeightOfTree {
    private int findMaximumHeight(List<Integer> edgeList[], int startNode, boolean visited[]) {
        int height = 0;

        List<Integer> childNodes = edgeList[startNode];

        for(Integer eachChild : childNodes) {
            if(!visited[eachChild]) {
                visited[eachChild] = true;

                int currentChildHeight = findMaximumHeight(edgeList, eachChild, visited) + 1;
                height = Math.max(height, currentChildHeight);
            }
        }

        return height;
    }

    public static void main(String[] args) {
        HeightOfTree heightOfTree = new HeightOfTree();
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        List<Integer> edgeList[] = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            edgeList[u].add(v);
            edgeList[v].add(u);
        }

        int startNode = 1;

        boolean visited[] = new boolean[N + 1];

        visited[1] = true;

        int maxHeight = heightOfTree.findMaximumHeight(edgeList, startNode, visited);

        System.out.println(maxHeight);
    }
}
