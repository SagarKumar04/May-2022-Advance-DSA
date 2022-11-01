/*
Leetcode Link: https://leetcode.com/problems/delete-operation-for-two-strings/
 */

package DynamicProgramming.Leetcode;

public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        char word1CharArr[] = word1.toCharArray();
        char word2CharArr[] = word2.toCharArray();

        int word1Length = word1CharArr.length;
        int word2Length = word2CharArr.length;

        int lcsTable[][] = new int[word1Length + 1][word2Length + 1];

        for(int i = 0; i <= word1Length; i++) {
            for(int j = 0; j <= word2Length; j++) {
                //not considering any character from one of the strings
                if(i == 0 || j == 0) {
                    lcsTable[i][j] = 0;
                }
                else if(word1CharArr[i - 1] == word2CharArr[j - 1]) {
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

        int lengthOfLcs = lcsTable[word1Length][word2Length];

        int minimumNumberOfSteps = (word1Length - lengthOfLcs) + (word2Length - lengthOfLcs);

        return minimumNumberOfSteps;
    }
}
