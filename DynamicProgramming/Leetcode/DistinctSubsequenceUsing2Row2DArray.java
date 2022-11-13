/*
Leetcode Link: https://leetcode.com/problems/distinct-subsequences/
 */

package DynamicProgramming.Leetcode;

public class DistinctSubsequenceUsing2Row2DArray {
    public int numDistinct(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();

        int distinctSubsequenceCount[][] = new int[2][lengthS + 1];

        for(int i = 0; i <= lengthS; i++) {
            distinctSubsequenceCount[0][i] = 1;
        }

        for(int i = 1; i <= lengthT; i++) {
            for(int j = 1; j <= lengthS; j++) {
                if(t.charAt(i - 1) == s.charAt(j - 1)) {
                    distinctSubsequenceCount[1][j]
                            = distinctSubsequenceCount[0][j - 1] //taking the current character from 's' into consideration
                            + distinctSubsequenceCount[1][j - 1]; //not taking the current character from 's' into consideration
                }
                else {
                    distinctSubsequenceCount[1][j] = distinctSubsequenceCount[1][j - 1]; //not taking the current character from 's' into consideratio
                }
            }

            for(int j = 0; j <= lengthS; j++) {
                distinctSubsequenceCount[0][j] = distinctSubsequenceCount[1][j];
            }
        }

        return distinctSubsequenceCount[1][lengthS];
    }
}
