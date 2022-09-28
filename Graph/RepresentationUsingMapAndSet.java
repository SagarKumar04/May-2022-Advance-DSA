package Graph;

import java.util.*;

public class RepresentationUsingMapAndSet {
    Map<Object, HashSet<Object>> graph;

    RepresentationUsingMapAndSet() {
        graph = new HashMap<>();
    }

    private boolean checkIfEdgeExists(Object u, Object v) {
        if(graph.containsKey(u)) {
            if(graph.get(u).contains(v)) {
                return true;
            }
        }

        return false;
    }

    private void deleteEdge(Object u, Object v) {
        if(graph.containsKey(u)) {
           graph.get(u).remove(v);
        }

        if(graph.containsKey(v)) {
            graph.get(v).remove(u);
        }
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

    public static void main(String[] args) {
        RepresentationUsingMapAndSet representationUsingMapAndSet
                = new RepresentationUsingMapAndSet();


    }
}
