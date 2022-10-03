/*
Leetcode Link: https://leetcode.com/problems/01-matrix/
 */

package Graph.Questions.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    class Coordinates {
        int x;
        int y;

        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int rowLength = mat.length;
        int columnLength = mat[0].length;

        boolean visited[][] = new boolean[rowLength][columnLength];

        Queue<Coordinates> queue = new LinkedList<>();

        for(int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new Coordinates(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int directions[][] = {
                {-1, 0}, //up
                {0, 1}, //right
                {1, 0}, //down
                {0, -1} //left
        };

        while(!queue.isEmpty()) {
            Coordinates coordinates = queue.poll();

            for(int i = 0; i < directions.length; i++) {
                int nextRow = coordinates.x + directions[i][0];
                int nextColumn = coordinates.y + directions[i][1];

                if(nextRow < 0
                || nextRow >= rowLength
                || nextColumn < 0
                || nextColumn >= columnLength
                || visited[nextRow][nextColumn]) {
                    continue;
                }

                visited[nextRow][nextColumn] = true;
                mat[nextRow][nextColumn] = mat[coordinates.x][coordinates.y] + 1;
                queue.add(new Coordinates(nextRow, nextColumn));
            }
        }

        return mat;
    }
}
