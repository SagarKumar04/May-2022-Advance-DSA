package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckCycleInUndirectedGraph {
    Map<Object, HashSet<Object>> graph;
    int count;

    CheckCycleInUndirectedGraph() {
        graph = new HashMap<>();
        count = 0;
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

    private boolean isCyclicHelper(Object currentNode, Object parentNode, Set<Object> visitedSet) {
        visitedSet.add(currentNode);

        HashSet<Object> neighbours = graph.get(currentNode);

        for(Object eachNeighbour : neighbours) {
            if(!visitedSet.contains(eachNeighbour)) {
                if(isCyclicHelper(eachNeighbour, currentNode, visitedSet)) {
                    return true;
                }
            }
            else if(eachNeighbour != parentNode) {
                return true;
            }
            else {
                //no cycle
            }
        }

        return false;
    }

    private boolean isCyclic() {
        Set<Object> visitedSet = new HashSet<>();

        for(Object eachKey : graph.keySet()) {
            if(!visitedSet.contains(eachKey)) {
                count++;
                if(isCyclicHelper(eachKey, null, visitedSet)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CheckCycleInUndirectedGraph graph1
                = new CheckCycleInUndirectedGraph();
        boolean hasCycle;

        //graph with no disconnected component and no cycle
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);
        graph1.addEdge(4, 5);
        hasCycle = graph1.isCyclic();
        System.out.println("Has Cycle?: " + hasCycle);
        System.out.println("Count: " + graph1.count);

        System.out.println();

        //graph with no disconnected component and has cycle
        CheckCycleInUndirectedGraph graph2
                = new CheckCycleInUndirectedGraph();
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 4);
        graph2.addEdge(4, 5);
        graph2.addEdge(5, 1);
        hasCycle = graph2.isCyclic();
        System.out.println("Has Cycle?: " + hasCycle);
        System.out.println("Count: " + graph2.count);

        System.out.println();

        //graph with two disconnected component and no cycle
        CheckCycleInUndirectedGraph graph3
                = new CheckCycleInUndirectedGraph();
        graph3.addEdge(1, 2);
        graph3.addEdge(2, 3);
        graph3.addEdge(3, 4);
        graph3.addEdge(4, 5);

        graph3.addEdge(6, 7);
        graph3.addEdge(7, 8);
        graph3.addEdge(8, 9);
        hasCycle = graph3.isCyclic();
        System.out.println("Has Cycle?: " + hasCycle);
        System.out.println("Count: " + graph3.count);

        System.out.println();

        //graph with two disconnected component and has cycle
        CheckCycleInUndirectedGraph graph4
                = new CheckCycleInUndirectedGraph();
        graph4.addEdge(1, 2);
        graph4.addEdge(2, 3);
        graph4.addEdge(3, 4);
        graph4.addEdge(4, 5);

        graph4.addEdge(6, 7);
        graph4.addEdge(7, 8);
        graph4.addEdge(8, 9);
        graph4.addEdge(9, 6);
        hasCycle = graph4.isCyclic();
        System.out.println("Has Cycle?: " + hasCycle);
        System.out.println("Count: " + graph4.count);

        System.out.println();

        //graph with three disconnected component and no cycle
        CheckCycleInUndirectedGraph graph5
                = new CheckCycleInUndirectedGraph();
        graph5.addEdge(1, 2);
        graph5.addEdge(2, 3);
        graph5.addEdge(3, 4);
        graph5.addEdge(4, 5);

        graph5.addEdge(6, 7);
        graph5.addEdge(7, 8);
        graph5.addEdge(8, 9);

        graph5.addEdge(10, 11);
        graph5.addEdge(11, 12);
        graph5.addEdge(12, 13);

        hasCycle = graph5.isCyclic();
        System.out.println("Has Cycle?: " + hasCycle);
        System.out.println("Count: " + graph5.count);
    }
}
