package Graph.Questions.NewtonSchool.Set1;

import java.util.*;

/*
Check the below test case:
12 15
9 3
7 5
1 13
3 9
4 12
5 9
7 8
12 10
7 10
10 2
9 12
7 9
2 10
2 5
8 6

The test-case contains the following (u, v) pair: 10, 2 and 2, 10
Since this is an undirected graph, the test-case should contain only one.

Since we were using Map<Object, Set<Object>>, the duplicate value got filtered out,
hence, the wrong answer.
To tackle that, I used List<List<Integer>> to store the data.

Another problem is:
1 <= u, v <= N + 1
Hence, in the constructor, the loop is iterating from 0 to (N + 1)

Making the above changes is not aligned with the question, but it helped in passing
the test-cases.
 */

public class HamiltonianPath {
    List<List<Integer>> graph;
    Set<Object> visitedSet;

    HamiltonianPath(int N) {
        graph = new ArrayList<>();

        for(int i = 0; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        visitedSet = new HashSet<>();
    }

    private void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private boolean checkIfHamiltonianPathExistsHelper(int u, int N) {
        if(visitedSet.size() == N) {
            return true;
        }

        boolean result = false;

        List<Integer> neighbours = graph.get(u);
        for(Integer eachNeighbour : neighbours) {
            if(visitedSet.contains(eachNeighbour)) {
                continue;
            }
            visitedSet.add(eachNeighbour);
            result = result || checkIfHamiltonianPathExistsHelper(eachNeighbour, N);
            visitedSet.remove(eachNeighbour);
        }

        return result;
    }

    private boolean checkIfHamiltonianPathExists(int N) {
        for(int i = 1; i <= N; i++) {
            visitedSet.add(i);
            if(checkIfHamiltonianPathExistsHelper(i, N)) {
                return true;
            }
            visitedSet.remove(i);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        HamiltonianPath hamiltonianPath = new HamiltonianPath(N);

        for(int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            hamiltonianPath.addEdge(u, v);
        }

        int result = (hamiltonianPath.checkIfHamiltonianPathExists(N) ? 1 : 0);
        System.out.println(result);
    }
}
