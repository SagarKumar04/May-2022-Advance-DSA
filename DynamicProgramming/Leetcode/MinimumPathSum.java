/*
Leetcode Link: https://leetcode.com/problems/minimum-path-sum/
 */

package DynamicProgramming.Leetcode;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;

        //first column
        for(int i = 1; i < numberOfRows; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        //first row
        for(int i = 1; i < numberOfColumns; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }

        for(int i = 1; i < numberOfRows; i++) {
            for(int j = 1; j < numberOfColumns; j++) {
                grid[i][j] = grid[i][j] + Math.min(
                        grid[i - 1][j],
                        grid[i][j - 1]
                );
            }
        }

        return grid[numberOfRows - 1][numberOfColumns - 1];
    }
}
