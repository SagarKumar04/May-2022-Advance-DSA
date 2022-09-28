package Graph;

public class AdjacencyMatrixRepresentation {
    int adjacencyMatrix[][];

    AdjacencyMatrixRepresentation(int N) {
        adjacencyMatrix = new int[N][N];
    }

    private boolean checkIfEdgeExists(int u, int v) {
        if(adjacencyMatrix[u][v] == 1) {
            return true;
        }
        return false;
    }

    private void deleteEdge(int u, int v) {
        adjacencyMatrix[u][v] = 0;
        adjacencyMatrix[v][u] = 0;
    }

    private void addEdge(int u, int v) {
        adjacencyMatrix[u][v] = 1;
        adjacencyMatrix[v][u] = 1;
    }

    public static void main(String[] args) {
        int N = 5;

        AdjacencyMatrixRepresentation adjacencyMatrixRepresentation
                = new AdjacencyMatrixRepresentation(N);


    }
}
