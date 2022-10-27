/*
Leetcode Link: https://leetcode.com/problems/triangle/
 */

package DynamicProgramming.Leetcode;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int numberOfRows = triangle.size();
        int maximumNumberOfColumns = triangle.get(numberOfRows - 1).size();

        int sum[] = new int[maximumNumberOfColumns];

        //initialize the 'sum' array
        List<Integer> lastRow = triangle.get(numberOfRows - 1);
        for(int i = 0; i < maximumNumberOfColumns; i++) {
            sum[i] = lastRow.get(i);
        }

        for(int i = numberOfRows - 2; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);

            for(int j = 0; j < currentRow.size(); j++) {
                sum[j] = Math.min(sum[j], sum[j + 1]) + currentRow.get(j);
            }
        }

        return sum[0];
    }
}
