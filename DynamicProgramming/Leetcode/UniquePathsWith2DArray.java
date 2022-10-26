/*
Leetcode Link: https://leetcode.com/problems/unique-paths/
 */

package DynamicProgramming.Leetcode;

public class UniquePathsWith2DArray {
    public int uniquePaths(int m, int n) {
        int pathDp[][] = new int[m][n];

        //first row
        for(int i = 0; i < n; i++) {
            pathDp[0][i] = 1;
        }

        //first column
        for(int i = 0; i < m; i++) {
            pathDp[i][0] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                pathDp[i][j] = pathDp[i - 1][j] + pathDp[i][j - 1];
            }
        }

        return pathDp[m - 1][n - 1];
    }
}
