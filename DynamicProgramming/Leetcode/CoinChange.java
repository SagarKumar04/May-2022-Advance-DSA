/*
Leetcode Link: https://leetcode.com/problems/coin-change/
 */

package DynamicProgramming.Leetcode;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int coinTable[] = new int[amount + 1];

        for(int i = 1; i <= amount; i++) {
            int minimum = Integer.MAX_VALUE;

            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    int remainingAmount = i - coins[j];
                    int remainingAmountMinimum = coinTable[remainingAmount];

                    if(remainingAmountMinimum != -1) {
                        if(remainingAmountMinimum < minimum) {
                            minimum = remainingAmountMinimum;
                        }
                    }
                    /*
                    Line numbers 16 to 19 can be condensed into:
                    if(coinTable[i - coins[j]] != -1) {

                    }
                     */
                }
            }

            if(minimum != Integer.MAX_VALUE) {
                coinTable[i] = minimum + 1;
            }
            else {
                coinTable[i] = -1;
            }
        }

        return coinTable[amount];
    }
}
