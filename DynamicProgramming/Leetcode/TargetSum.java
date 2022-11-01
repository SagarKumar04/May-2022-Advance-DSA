/*
Leetcode Link: https://leetcode.com/problems/target-sum/
 */

package DynamicProgramming.Leetcode;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for(int eachNum : nums) {
            sum += eachNum;
        }

        /*
        -sum <= target <= sum
         */
        if(target < -sum || target > sum) {
            return 0;
        }

        int minimum = 0;
        int maximum = 2 * sum + 1;

        int numberOfWays[][] = new int[nums.length + 1][maximum];
        numberOfWays[0][sum] = 1;

        for(int i = 1; i <= nums.length; i++) {
            for(int j = 0; j < maximum; j++) {
                /*
                dp[i][j]
                    = dp[i - 1][j - nums[i - 1]]
                    + dp[i - 1][j + nums[i - 1]]
                 */
                if(j - nums[i - 1] >= minimum) {
                    numberOfWays[i][j] += numberOfWays[i - 1][j - nums[i - 1]];
                }
                if(j + nums[i - 1] < maximum) {
                    numberOfWays[i][j] += numberOfWays[i - 1][j + nums[i - 1]];
                }
            }
        }

        return numberOfWays[nums.length][sum + target];
    }
}
