/*
Leetcode Link: https://leetcode.com/problems/candy/
 */

package GreedyAlgorithms.Leetcode;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies[] = new int[n];

        for(int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        int totalCandies = candies[n - 1];
        for(int i = (n - 2); i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            totalCandies += candies[i];
        }

        return totalCandies;
    }
}
