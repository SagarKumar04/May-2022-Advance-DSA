package Graph.Questions.Leetcode;

import java.util.*;

public class CourseScheduleII {
    Map<Object, HashSet<Object>> graph;
    Map<Object, Integer> indegreeMap;

    private void addEdge(Object u, Object v) {
        if(!graph.containsKey(u)) {
            graph.put(u, new HashSet<>());
        }

        graph.get(u).add(v);

        int currentIndegree = indegreeMap.get(v);
        indegreeMap.put(v, currentIndegree + 1);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new HashMap<>();
        indegreeMap = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            indegreeMap.put(i, 0);
        }

        int prerequisitesSize = prerequisites.length;

        for(int i = 0; i < prerequisitesSize; i++) {
            Object u = prerequisites[i][1];
            Object v = prerequisites[i][0];

            addEdge(u, v);
        }

        List<Object> courseOrder = new ArrayList<>();

        Queue<Object> nodesWithZeroIndegree = new LinkedList<>();
        for(Object key : indegreeMap.keySet()) {
            if(indegreeMap.get(key) == 0) {
                nodesWithZeroIndegree.add(key);
            }
        }

        while(!nodesWithZeroIndegree.isEmpty()) {
            Object course = nodesWithZeroIndegree.poll();

            courseOrder.add(course);

            HashSet<Object> neighbours = graph.get(course);

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

        if(indegreeMap.size() != courseOrder.size()) {
            courseOrder.clear();
        }

        int courseOrderListSize = courseOrder.size();
        int courseOrderArray[] = new int[courseOrderListSize];

        for(int i = 0; i < courseOrderListSize; i++) {
            courseOrderArray[i] = (Integer)courseOrder.get(i);
        }

        return courseOrderArray;
    }
}
