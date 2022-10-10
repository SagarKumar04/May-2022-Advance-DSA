/*
Leetcode Link: https://leetcode.com/problems/minimum-absolute-difference/submissions/
 */

package GreedyAlgorithms.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        int minimumDifference = Integer.MAX_VALUE;

        for(int i = 1; i < arr.length; i++) {
            int currentDifference = arr[i] - arr[i - 1];

            if(currentDifference > minimumDifference) {
                continue;
            }

            if(currentDifference < minimumDifference) {
                minimumDifference = currentDifference;
                result.clear();
            }

            result.add(Arrays.asList(arr[i - 1], arr[i]));
        }

        return result;
    }
}
