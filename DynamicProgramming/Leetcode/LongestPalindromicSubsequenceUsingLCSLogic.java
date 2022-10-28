/*
Leetcode Link: https://leetcode.com/problems/longest-palindromic-subsequence/
 */

package DynamicProgramming.Leetcode;

public class LongestPalindromicSubsequenceUsingLCSLogic {
    public int longestCommonSubsequence(String text1, String text2) {
        char text1CharArr[] = text1.toCharArray();
        char text2CharArr[] = text2.toCharArray();

        int text1Length = text1CharArr.length;
        int text2Length = text2CharArr.length;

        int lcsTable[][] = new int[text1Length + 1][text2Length + 1];

        for(int i = 0; i <= text1Length; i++) {
            for(int j = 0; j <= text2Length; j++) {
                //not considering any character from one of the strings
                if(i == 0 || j == 0) {
                    lcsTable[i][j] = 0;
                }
                else if(text1CharArr[i - 1] == text2CharArr[j - 1]) {
                    lcsTable[i][j] = lcsTable[i - 1][j - 1] + 1;
                }
                else {
                    lcsTable[i][j] = Math.max(
                            lcsTable[i][j - 1],
                            lcsTable[i - 1][j]
                    );
                }
            }
        }

        return lcsTable[text1Length][text2Length];
    }

    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String r = sb.reverse().toString();

        int lpsLength = longestCommonSubsequence(s, r);

        return lpsLength;
    }
}
