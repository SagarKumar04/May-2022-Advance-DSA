/*
Leetcode Link: https://leetcode.com/problems/count-sorted-vowel-strings/
 */

package DynamicProgramming.Leetcode;

public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        int vowelStringsCount[][] = new int[n + 1][5];

        for(int i = 0; i <= n; i++) {
            for(int j = 4; j >= 0; j--) {
                if(i == 0 || j == 4) {
                    vowelStringsCount[i][j] = 1;
                }
                else {
                    vowelStringsCount[i][j]
                            = vowelStringsCount[i][j + 1]
                            + vowelStringsCount[i - 1][j];
                }
            }
        }

        return vowelStringsCount[n][0];
    }
}
