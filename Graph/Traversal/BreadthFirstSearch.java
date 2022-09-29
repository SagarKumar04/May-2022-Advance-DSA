package Graph.Traversal;

import java.util.*;

public class BreadthFirstSearch {
    Map<Object, HashSet<Object>> graph;

    BreadthFirstSearch() {
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

    private void bfsTraversal(Object startingVertex) {
        Set<Object> visitedSet = new HashSet<>();
        Queue<Object> queue = new LinkedList<>();

        visitedSet.add(startingVertex);
        queue.add(startingVertex);

        while(!queue.isEmpty()) {
            Object currentNode = queue.poll();
            System.out.print(currentNode + " ");

            HashSet<Object> neighbours = graph.get(currentNode);
            for(Object eachNeighbour : neighbours) {
                if(!visitedSet.contains(eachNeighbour)) {
                    queue.add(eachNeighbour);
                    visitedSet.add(eachNeighbour);
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

        breadthFirstSearch.addEdge(1, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 4);
        breadthFirstSearch.addEdge(2, 5);
        breadthFirstSearch.addEdge(3, 5);
        breadthFirstSearch.addEdge(4, 5);
        breadthFirstSearch.addEdge(4, 6);
        breadthFirstSearch.addEdge(5, 6);

        System.out.println(breadthFirstSearch.graph);

        breadthFirstSearch.bfsTraversal(3);
    }
}
