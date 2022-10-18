package GreedyAlgorithms.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;

        //put all intervals in the 'result' which is not overlapping with the 'newInterval'
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        //merge the overlapping intervals
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        //put the remaining intervals in the 'result'
        while(i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        int finalResult[][] = result.toArray(new int[result.size()][2]);

        return finalResult;
    }
}
