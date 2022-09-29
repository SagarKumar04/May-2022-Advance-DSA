package Graph.Traversal;

import java.util.*;

public class DepthFirstSearch {
    Map<Object, HashSet<Object>> graph;
    
    DepthFirstSearch() {
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

    private void dfsTraversal(Object startingVertex) {
        Set<Object> visitedSet = new HashSet<>();
        Stack<Object> stack = new Stack<>();

        stack.add(startingVertex);

        while(!stack.isEmpty()) {
            Object currentNode = stack.pop();

            if(!visitedSet.contains(currentNode)) {
                System.out.print(currentNode + " ");
                visitedSet.add(currentNode);
            }

            HashSet<Object> neighbours = graph.get(currentNode);
            for(Object eachNeighbour : neighbours) {
                if (!visitedSet.contains(eachNeighbour)) {
                    stack.add(eachNeighbour);
                }
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();

        depthFirstSearch.addEdge('a', 'b');
        depthFirstSearch.addEdge('a', 'c');
        depthFirstSearch.addEdge('b', 'd');
        depthFirstSearch.addEdge('b', 'e');
        depthFirstSearch.addEdge('c', 'e');
        depthFirstSearch.addEdge('d', 'e');
        depthFirstSearch.addEdge('d', 'f');
        depthFirstSearch.addEdge('e', 'f');

        System.out.println(depthFirstSearch.graph);

        depthFirstSearch.dfsTraversal('c');
    }
}
