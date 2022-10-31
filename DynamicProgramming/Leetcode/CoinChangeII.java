/*
Leetcode Link: https://leetcode.com/problems/coin-change-ii/
 */

package DynamicProgramming.Leetcode;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int numberOfWaysTable[] = new int[amount + 1];

        numberOfWaysTable[0] = 1;

        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j <= amount; j++) {
                numberOfWaysTable[j] = numberOfWaysTable[j] +
                        numberOfWaysTable[j - coins[i]];
            }
        }

        return numberOfWaysTable[amount];
    }
}
