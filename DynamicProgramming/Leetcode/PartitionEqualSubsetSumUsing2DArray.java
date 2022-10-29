/*
Leetcode Link: https://leetcode.com/problems/partition-equal-subset-sum/
 */

package DynamicProgramming.Leetcode;

public class PartitionEqualSubsetSumUsing2DArray {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int eachNum : nums) {
            sum += eachNum;
        }

        //if sum of all the elements in the 'nums' array is an odd number
        if(sum % 2 == 1) {
            return false;
        }

        //if sum of all the elements in the 'nums' array is an even number
        sum = sum / 2;
        int n = nums.length;

        boolean subsetSumMatrix[][] = new boolean[n + 1][sum + 1];

        subsetSumMatrix[0][0] = true;

        //first column
        for(int i = 1; i <= n; i++) {
            subsetSumMatrix[i][0] = true;
        }

        //first row
        for(int i = 1; i <= sum; i++) {
            subsetSumMatrix[0][i] = false;
        }

        //remaining
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                subsetSumMatrix[i][j] = subsetSumMatrix[i - 1][j];
                if(j >= nums[i - 1]) {
                    subsetSumMatrix[i][j]
                            /*
                            not considering the current number -> subsetSumMatrix[i][j]
                            considering the current number -> subsetSumMatrix[i - 1][j - nums[i - 1]]
                             */
                            = subsetSumMatrix[i][j] || subsetSumMatrix[i - 1][j - nums[i - 1]];
                }
            }
        }

        return subsetSumMatrix[n][sum];
    }
}
