package Graph.Questions.NewtonSchool.Set1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestSourceToDestination {
    class Coordinates {
        int x;
        int y;
        int steps;

        Coordinates(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }

    private int findMinimumSteps(int graph[][], int x, int y) {
        int directions[][] = {
                {-1, 0}, //up
                {0, 1}, //right
                {1, 0}, //down
                {0, -1} //left
        };

        if(graph[0][0] != 1 || graph[x][y] != 1) {
            return -1;
        }

        Queue<Coordinates> queue = new LinkedList<>();
        queue.add(new Coordinates(0, 0, 0));

        while(!queue.isEmpty()) {
            Coordinates coordinates = queue.poll();
            int currentX = coordinates.x;
            int currentY = coordinates.y;
            int steps = coordinates.steps;

            if(currentX == x && currentY == y) {
                return steps;
            }

            for(int i = 0; i < directions.length; i++) {
                int nextRow = coordinates.x + directions[i][0];
                int nextColumn = coordinates.y + directions[i][1];

                if(nextRow < 0
                        || nextRow >= graph.length
                        || nextColumn < 0
                        || nextColumn >= graph[0].length
                        || graph[nextRow][nextColumn] != 1) {
                    continue;
                }

                graph[nextRow][nextColumn] = -1;
                queue.add(new Coordinates(nextRow, nextColumn, steps + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShortestSourceToDestination shortestSourceToDestination
                = new ShortestSourceToDestination();

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int graph[][] = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int result = shortestSourceToDestination.findMinimumSteps(graph, x, y);
        System.out.println(result);
    }
}
