/*
Leetcode Link: https://leetcode.com/problems/minimum-falling-path-sum/
 */

package DynamicProgramming.Leetcode;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int minimumFallingPathSum[][] = new int[n][n + 2];

        //put 'infinite' in the first and the last column
        for(int i = 0; i < n; i++) {
            minimumFallingPathSum[i][0] = Integer.MAX_VALUE;
            minimumFallingPathSum[i][n + 1] = Integer.MAX_VALUE;
        }

        /*
        put the values from the first row of the input array in the
        minimumFallingPathSum array
         */
        for(int i = 1; i <= n; i++) {
            minimumFallingPathSum[0][i] = matrix[0][i - 1];
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                minimumFallingPathSum[i][j] = Math.min(
                        minimumFallingPathSum[i - 1][j],
                        Math.min(
                            minimumFallingPathSum[i - 1][j - 1],
                            minimumFallingPathSum[i - 1][j + 1]
                        )
                ) + matrix[i][j - 1];
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            result = Math.min(result, minimumFallingPathSum[n - 1][i]);
        }

        return result;
    }
}
