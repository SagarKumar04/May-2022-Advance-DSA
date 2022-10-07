package Graph;

import java.util.*;

public class TopologicalSort {
    Map<Object, HashSet<Object>> graph;
    Map<Object, Integer> indegreeMap;

    TopologicalSort() {
        graph = new HashMap<>();
        indegreeMap = new HashMap<>();
    }

    private void addEdge(Object u, Object v) {
        if(!graph.containsKey(u)) {
            graph.put(u, new HashSet<>());
        }

        if(!indegreeMap.containsKey(u)) {
            indegreeMap.put(u, 0);
        }
        if(!indegreeMap.containsKey(v)) {
            indegreeMap.put(v, 0);
        }

        graph.get(u).add(v);

        int currentIndegree = indegreeMap.get(v);
        indegreeMap.put(v, currentIndegree + 1);
    }

    private List<Object> getTopologicalSort() {
        List<Object> topologicalSort = new ArrayList<>();

        Queue<Object> nodesWithIndegreeZero = new LinkedList<>();
        for(Object key : indegreeMap.keySet()) {
            if(indegreeMap.get(key) == 0) {
                nodesWithIndegreeZero.add(key);
            }
        }

        while(!nodesWithIndegreeZero.isEmpty()) {
            Object node = nodesWithIndegreeZero.poll();

            topologicalSort.add(node);

            HashSet<Object> neighbours = graph.get(node);

            if(neighbours != null) {
                for(Object eachNeighbour : neighbours) {
                    int newIndegree = indegreeMap.get(eachNeighbour) - 1;
                    indegreeMap.put(eachNeighbour, newIndegree);

                    if(newIndegree == 0) {
                        nodesWithIndegreeZero.add(eachNeighbour);
                    }
                }
            }
        }

        /*
        If the number of elements in the 'topologicalSort' is not equal to
        the total number of nodes in the graph, then the graph is not in the
        required format.
         */
        if(indegreeMap.size() != topologicalSort.size()) {
            topologicalSort.clear();
        }

        return topologicalSort;
    }

    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();

        topologicalSort.addEdge(5, 0);
        topologicalSort.addEdge(4, 0);
        topologicalSort.addEdge(5, 2);
        topologicalSort.addEdge(4, 1);
        topologicalSort.addEdge(2, 3);
        topologicalSort.addEdge(3, 1);

        //topologicalSort.addEdge(1, 2);

        System.out.println("Graph: " + topologicalSort.graph);
        System.out.println("Indegree: " + topologicalSort.indegreeMap);

        List<Object> topologicalSortResult = topologicalSort.getTopologicalSort();

        System.out.println("Topological Sort: " + topologicalSortResult);
    }
}
