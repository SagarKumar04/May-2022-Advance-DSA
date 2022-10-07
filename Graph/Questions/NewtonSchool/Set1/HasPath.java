package Graph.Questions.NewtonSchool.Set1;

import java.util.*;

public class HasPath {
    Map<Object, HashSet<Object>> graph;

    HasPath() {
        graph = new HashMap<>();
    }

    private void addEdge(Object u, Object v) {
        if(!graph.containsKey(u)) {
            graph.put(u, new HashSet<>());
        }

        if(!graph.containsKey(v)) {
            graph.put(v, new HashSet<>());
        }

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private boolean checkIfPathExists(Object u, Object v) {
        Set<Object> visitedSet = new HashSet<>();
        Stack<Object> stack = new Stack<>();

        stack.add(u);

        while(!stack.isEmpty()) {
            Object currentNode = stack.pop();

            if(!visitedSet.contains(currentNode)) {
                if(currentNode == v) {
                    return true;
                }
                visitedSet.add(currentNode);
            }

            HashSet<Object> neighbours = graph.get(currentNode);
            for(Object eachNeighbour : neighbours) {
                if (!visitedSet.contains(eachNeighbour)) {
                    stack.add(eachNeighbour);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        HasPath hasPath = new HasPath();
        Scanner scanner = new Scanner(System.in);

        int V = scanner.nextInt();
        int E = scanner.nextInt();

        for(int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            hasPath.addEdge(u, v);
        }

        int u = scanner.nextInt();
        int v = scanner.nextInt();
        boolean result = hasPath.checkIfPathExists(u, v);

        System.out.println(result);
    }
}
