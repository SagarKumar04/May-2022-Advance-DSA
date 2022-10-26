/*
Leetcode Link: https://leetcode.com/problems/unique-paths-ii/
 */

package DynamicProgramming.Leetcode;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int pathDp[][] = new int[m][n];

        //first row
        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                pathDp[0][i] = 0;
                break;
            }

            pathDp[0][i] = 1;
        }

        //first column
        for(int i = 0; i < m; i++) {


            if(obstacleGrid[i][0] == 1) {
                pathDp[i][0] = 0;
                break;
            }

            pathDp[i][0] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    pathDp[i][j] = 0;
                }
                else {
                    pathDp[i][j] = pathDp[i - 1][j] + pathDp[i][j - 1];
                }
            }
        }

        return pathDp[m - 1][n - 1];
    }
}
