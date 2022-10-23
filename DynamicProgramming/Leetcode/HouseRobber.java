/*
Leetcode Link: https://leetcode.com/problems/house-robber/
 */

package DynamicProgramming.Leetcode;

public class HouseRobber {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 1) {
            return nums[0];
        }

        if(length == 2) {
            return (Math.max(nums[0], nums[1]));
        }

        int maximumMoney[] = new int[length + 1];

        maximumMoney[0] = 0;
        maximumMoney[1] = nums[0];

        for(int i = 2; i <= length; i++) {
            maximumMoney[i] = Math.max(
                    maximumMoney[i - 2] + nums[i - 1],
                    maximumMoney[i - 1]
            );
        }

        return maximumMoney[length];
    }
}
