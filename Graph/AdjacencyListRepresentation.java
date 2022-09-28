package Graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListRepresentation {
    List<List<Integer>> adjacencyList;

    AdjacencyListRepresentation(int N) {
        adjacencyList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    private boolean checkIfEdgeExists(int u, int v) {
        if(adjacencyList.get(u).contains(v)) {
            return true;
        }
        return false;
    }

    private void deleteEdge(Integer u, Integer v) {
        adjacencyList.get(u).remove(v);
        adjacencyList.get(v).remove(u);
    }

    private void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    public static void main(String[] args) {
        int N = 5;

        AdjacencyListRepresentation adjacencyListRepresentation
                = new AdjacencyListRepresentation(N);

        adjacencyListRepresentation.deleteEdge(3, 4);
    }
}
