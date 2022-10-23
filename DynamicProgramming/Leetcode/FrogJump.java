/*
Leetcode Link: https://leetcode.com/problems/frog-jump/
 */

package DynamicProgramming.Leetcode;

public class FrogJump {
    public boolean canCross(int[] stones) {
        int length = stones.length;

        boolean jumpData[][] = new boolean[length][length];
        jumpData[0][1] = true;

        for(int i = 1; i < length; i++) {
            for(int j = 0; j < i; j++) {
                int distanceDifference = stones[i] - stones[j];

                if(distanceDifference < length && jumpData[j][distanceDifference]) {
                    if(distanceDifference - 1 >= 0) {
                        jumpData[i][distanceDifference - 1] = true;
                    }
                    jumpData[i][distanceDifference] = true;
                    if(distanceDifference + 1 < length) {
                        jumpData[i][distanceDifference + 1] = true;
                    }

                    if(i == length - 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
