package Graph.Questions.NewtonSchool.Set2;

import java.util.*;

public class DetectCycleInUndirectedGraph {
    Map<Object, HashSet<Object>> graph;
    int count;

    DetectCycleInUndirectedGraph(int N) {
        graph = new HashMap<>();
        count = 0;
    }

    private void addEdge(int u, int v) {
        if(!graph.containsKey(u)) {
            graph.put(u, new HashSet<>());
        }

        if(!graph.containsKey(v)) {
            graph.put(v, new HashSet<>());
        }

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private boolean isCyclicHelper(Object  currentNode, Object parentNode, Set<Object> visitedSet) {
        visitedSet.add(currentNode);

        HashSet<Object> neighbours = graph.get(currentNode);

        for(Object eachNeighbour : neighbours) {
            if(!visitedSet.contains(eachNeighbour)) {
                if(isCyclicHelper(eachNeighbour, currentNode, visitedSet)) {
                    return true;
                }
            }
            else if(((Integer)eachNeighbour).intValue() != ((Integer)parentNode).intValue()) {
                return true;
            }
            else {
                //no cycle
            }
        }

        return false;
    }

    private boolean isCyclic(int N) {
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
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        DetectCycleInUndirectedGraph detectCycleInUndirectedGraph
                = new DetectCycleInUndirectedGraph(N);

        for(int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            detectCycleInUndirectedGraph.addEdge(u, v);
        }

        String result = (detectCycleInUndirectedGraph.isCyclic(N) ? "Yes" : "No");

        System.out.println(result);
    }
}
