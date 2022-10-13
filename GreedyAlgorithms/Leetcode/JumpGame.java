/*
Leetcode Link: https://leetcode.com/problems/jump-game/
 */

package GreedyAlgorithms.Leetcode;

public class JumpGame {
    public boolean canJump(int[] nums) {
        boolean result = false;
        int n = nums.length;
        int currentDestination = n - 1;

        for(int i = (n - 2); i >= 0; i--) {
            if(i + nums[i] >= currentDestination) {
                currentDestination = i;
            }
        }

        if(currentDestination == 0) {
            result = true;
        }

        return result;
    }
}
