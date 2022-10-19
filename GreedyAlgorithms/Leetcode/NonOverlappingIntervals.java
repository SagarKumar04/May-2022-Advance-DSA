/*
Leetcode Link: https://leetcode.com/problems/non-overlapping-intervals/
 */

package GreedyAlgorithms.Leetcode;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
        sort a 2-D array (of length n * 2) in increasing order
        on the basis of the first element of each 1-D array
         */
        Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]));

        int previousEnd = intervals[0][1];
        int deletedCount = 0;

        for(int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if(previousEnd > currentStart) {
                previousEnd = Math.min(previousEnd, currentEnd);
                deletedCount++;
            }
            else {
                previousEnd = currentEnd;
            }
        }

        return deletedCount;
    }
}
