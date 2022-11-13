/*
Leetcode Link: https://leetcode.com/problems/distinct-subsequences/
 */

package DynamicProgramming.Leetcode;

public class DistinctSubsequencesUsing2DArray {
    public int numDistinct(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();

        int distinctSubsequenceCount[][] = new int[lengthT + 1][lengthS + 1];

        for(int i = 0; i <= lengthS; i++) {
            distinctSubsequenceCount[0][i] = 1;
        }

        for(int i = 1; i <= lengthT; i++) {
            for(int j = 1; j <= lengthS; j++) {
                if(t.charAt(i - 1) == s.charAt(j - 1)) {
                    distinctSubsequenceCount[i][j]
                            = distinctSubsequenceCount[i - 1][j - 1] //taking the current character from 's' into consideration
                            + distinctSubsequenceCount[i][j - 1]; //not taking the current character from 's' into consideration
                }
                else {
                    distinctSubsequenceCount[i][j] = distinctSubsequenceCount[i][j - 1]; //not taking the current character from 's' into consideratio
                }
            }
        }

        return distinctSubsequenceCount[lengthT][lengthS];
    }
}
