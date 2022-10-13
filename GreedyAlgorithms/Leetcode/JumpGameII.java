/*
Leetcode Link: https://leetcode.com/problems/jump-game-ii/
 */

package GreedyAlgorithms.Leetcode;

public class JumpGameII {
    public int jump(int[] nums) {
        int numberOfJumps = 0;
        int currentRangeEnd = 0;
        int farthest = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if(i == currentRangeEnd) {
                currentRangeEnd = farthest;
                numberOfJumps++;
            }
        }

        return numberOfJumps;
    }
}
