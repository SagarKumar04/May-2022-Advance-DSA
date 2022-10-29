/*
Leetcode Link: https://leetcode.com/problems/partition-equal-subset-sum/
 */

package DynamicProgramming.Leetcode;

public class PartitionEqualSubsetSumUsing1DArray {
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

        boolean subsetSumMatrix[] = new boolean[sum + 1];

        subsetSumMatrix[0] = true;

        //remaining
        for(int i = 0; i < nums.length; i++) {
            for(int j = 1; j <= sum; j++) {
                if(j >= nums[i]) {
                    subsetSumMatrix[j] = subsetSumMatrix[j] || subsetSumMatrix[j - nums[i]];
                }
            }
        }

        return subsetSumMatrix[sum];
    }
}
