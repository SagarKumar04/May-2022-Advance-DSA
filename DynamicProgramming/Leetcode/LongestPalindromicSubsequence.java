/*
Leetcode Link: https://leetcode.com/problems/longest-palindromic-subsequence/
 */

package DynamicProgramming.Leetcode;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();

        int lpsMatrix[][] = new int[length][length];
        for(int i = 0; i < length; i++) {
            lpsMatrix[i][i] = 1;
        }

        for(int currentLength = 2; currentLength <= length; currentLength++) {
            for(int start = 0; start <= (length - currentLength); start++) {
                int end = start + currentLength - 1;

                boolean startEqualsEnd = (s.charAt(start) == s.charAt(end));

                if(currentLength == 2 && startEqualsEnd) {
                    lpsMatrix[start][end] = 2;
                }
                else if(startEqualsEnd) {
                    lpsMatrix[start][end] = lpsMatrix[start + 1][end - 1] + 2;
                }
                else {
                    lpsMatrix[start][end] = Math.max(
                            lpsMatrix[start + 1][end],
                            lpsMatrix[start][end - 1]
                    );
                }
            }
        }

        return lpsMatrix[0][length - 1];
    }
}
