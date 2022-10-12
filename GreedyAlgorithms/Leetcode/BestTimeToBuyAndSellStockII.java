/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

package GreedyAlgorithms.Leetcode;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                int profit = prices[i] - prices[i - 1];
                totalProfit += profit;
            }
        }

        return totalProfit;
    }
}
