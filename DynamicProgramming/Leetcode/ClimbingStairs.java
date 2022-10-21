/*
Leetcode Link: https://leetcode.com/problems/climbing-stairs/
 */

package DynamicProgramming.Leetcode;

public class ClimbingStairs {
    public int climbStairsWithArray(int n) {
        if(n == 1 || n == 2) {
            return n;
        }

        int numberOfSteps[] = new int[n + 1];
        numberOfSteps[0] = 0;
        numberOfSteps[1] = 1;
        numberOfSteps[2] = 2;

        for(int i = 3; i <= n; i++) {
            numberOfSteps[i] = numberOfSteps[i - 1] + numberOfSteps[i - 2];
        }

        return numberOfSteps[n];
    }

    public int climbStairsWithoutArray(int n) {
        if(n == 1 || n == 2) {
            return n;
        }

        int first = 1;
        int second = 2;
        int third = 0;

        for(int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }
}
