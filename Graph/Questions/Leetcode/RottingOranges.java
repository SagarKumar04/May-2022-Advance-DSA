/*
Leetcode Link: https://leetcode.com/problems/rotting-oranges/
 */

package Graph.Questions.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    class Coordinates {
        int x;
        int y;

        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        Queue<Coordinates> queue = new LinkedList<>();
        int freshOrangeCount = 0;

        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < columnCount; j++) {
                if(grid[i][j] == 1) {
                    freshOrangeCount++;
                }
                else if(grid[i][j] == 2) {
                    queue.add(new Coordinates(i, j));
                }
                else {
                    //empty space
                }
            }
        }

        if(freshOrangeCount == 0) {
            return 0;
        }

        int directions[][] = {
                {-1, 0}, //up
                {0, 1}, //right
                {1, 0}, //down
                {0, -1} //left
        };

        int numberOfMinutes = 0;
        while(!queue.isEmpty()) {
            numberOfMinutes++;

            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Coordinates coordinates = queue.poll();

                for(int j = 0; j < directions.length; j++) {
                    int nextRow = coordinates.x + directions[j][0];
                    int nextColumn = coordinates.y + directions[j][1];

                    if(nextRow < 0
                            || nextRow >= rowCount
                            || nextColumn < 0
                            || nextColumn >= columnCount
                            || grid[nextRow][nextColumn] == 0
                            || grid[nextRow][nextColumn] == 2) {
                        continue;
                    }

                    grid[nextRow][nextColumn] = 2;
                    queue.add(new Coordinates(nextRow, nextColumn));
                    freshOrangeCount--;
                }
            }
        }

        numberOfMinutes--;

        return (freshOrangeCount > 0) ? numberOfMinutes : -1;
    }
}
