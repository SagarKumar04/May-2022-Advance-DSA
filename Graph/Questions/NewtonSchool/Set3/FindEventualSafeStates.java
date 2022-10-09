/*
Leetcode Link: https://leetcode.com/problems/find-eventual-safe-states/
 */

package Graph.Questions.NewtonSchool.Set3;

import java.util.*;

public class FindEventualSafeStates {
    Map<Object, HashSet<Object>> graphReversed;
    Map<Object, Integer> indegreeMap;

    private void addEdge(Object u, Object v) {
        graphReversed.get(u).add(v);

        int currentIndegree = indegreeMap.get(v);
        indegreeMap.put(v, currentIndegree + 1);
    }

    public int eventualSafeNodes(int[][] graph) {
        graphReversed = new HashMap<>();
        indegreeMap = new HashMap<>();

        int numberOfNodes = graph.length;

        for(int i = 0; i < numberOfNodes; i++) {
            graphReversed.put(i, new HashSet<>());
            indegreeMap.put(i, 0);
        }

        for(int i = 0; i < numberOfNodes; i++) {
            Object u = i;

            for(int j = 0; j < graph[i].length; j++) {
                Object v = graph[i][j];

                addEdge(v, u);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        Queue<Object> nodesWithZeroIndegree = new LinkedList<>();
        for(Object key : indegreeMap.keySet()) {
            if(indegreeMap.get(key) == 0) {
                nodesWithZeroIndegree.add(key);
            }
        }

        while(!nodesWithZeroIndegree.isEmpty()) {
            Integer course = (Integer)nodesWithZeroIndegree.poll();

            safeNodes.add(course);

            HashSet<Object> neighbours = graphReversed.get(course);

            if(neighbours != null) {
                for(Object eachNeighbour : neighbours) {
                    int newIndegree = indegreeMap.get(eachNeighbour) - 1;
                    indegreeMap.put(eachNeighbour, newIndegree);

                    if(newIndegree == 0) {
                        nodesWithZeroIndegree.add(eachNeighbour);
                    }
                }
            }
        }

        return safeNodes.size();
    }

    public static void main(String[] args) {
        FindEventualSafeStates findEventualSafeStates
                = new FindEventualSafeStates();

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        ArrayList<Integer> graph[] = new ArrayList[N];

        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            graph[u].add(v);
        }

        int graphJagged[][] = new int[N][];

        for(int i = 0; i < N; i++) {
            int size = graph[i].size();
            graphJagged[i] = new int[size];

            for(int j = 0; j < size; j++) {
                graphJagged[i][j] = graph[i].get(j);
            }
        }

        int result = findEventualSafeStates.eventualSafeNodes(graphJagged);

        System.out.println(result);
    }
}
