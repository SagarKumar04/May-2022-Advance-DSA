/*
Leetcode Link: https://leetcode.com/problems/shortest-common-supersequence/
 */

package DynamicProgramming.Leetcode;

public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        int scsTable[][] = new int[length1 + 1][length2 + 1];

        for(int i = 0; i <= length1; i++) {
            for(int j = 0; j <= length2; j++) {
                if(i == 0 || j == 0) {
                    scsTable[i][j] = Math.max(i, j);
                }
                else if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    scsTable[i][j] = 1 + scsTable[i - 1][j - 1];
                }
                else {
                    scsTable[i][j] = 1 + Math.min(
                            scsTable[i][j - 1],
                            scsTable[i - 1][j]
                    );
                }
            }
        }

        int lengthOfScs = scsTable[length1][length2];
        int i = length1;
        int j = length2;

        char result[] = new char[lengthOfScs];

        while(i > 0 && j > 0) {
            if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lengthOfScs--;
                result[lengthOfScs] = str1.charAt(i - 1);

                i--;
                j--;
            }
            else {
                lengthOfScs--;
                if(scsTable[i - 1][j] < scsTable[i][j - 1]) {
                    result[lengthOfScs] = str1.charAt(i - 1);
                    i--;
                }
                else {
                    result[lengthOfScs] = str2.charAt(j - 1);
                    j--;
                }
            }
        }

        while(i > 0) {
            lengthOfScs--;
            result[lengthOfScs] = str1.charAt(i - 1);
            i--;
        }

        while(j > 0) {
            lengthOfScs--;
            result[lengthOfScs] = str2.charAt(j - 1);
            j--;
        }

        return new String(result);
    }

    public static void main(String[] args) {
        ShortestCommonSupersequence shortestCommonSupersequence
                = new ShortestCommonSupersequence();

        shortestCommonSupersequence.shortestCommonSupersequence("pqqrst", "qqttps");
    }
}
