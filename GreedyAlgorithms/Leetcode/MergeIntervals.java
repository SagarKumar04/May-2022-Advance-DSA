/*
Leetcode Link: https://leetcode.com/problems/merge-intervals/
 */

package GreedyAlgorithms.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        /*
        sort a 2-D array (of length n * 2) in increasing order
        on the basis of the first element of each 1-D array
         */
        Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]));

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);
        int currentResultIndex = 0;

        for(int i = 1; i < intervals.length; i++) {
            int currentIntervalStart = intervals[i][0];
            int currentIntervalEnd = intervals[i][1];

            int lastInterval[] = result.get(currentResultIndex);
            int lastIntervalStart = lastInterval[0];
            int lastIntervalEnd = lastInterval[1];

            if(currentIntervalStart <= lastIntervalEnd) {
                lastIntervalEnd = Math.max(lastIntervalEnd, currentIntervalEnd);
                lastInterval[1] = lastIntervalEnd;
            }
            else {
                result.add(intervals[i]);
                currentResultIndex++;
            }
        }

        int finalResult[][] = result.toArray(new int[result.size()][2]);

        return finalResult;
    }
}
