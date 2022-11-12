/*
Leetcode Link: https://leetcode.com/problems/edit-distance/
 */

package DynamicProgramming.Leetcode;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        int minDistanceCount[][] = new int[length1 + 1][length2 + 1];

        for(int i = 0; i <= length1; i++) {
            for(int j = 0; j <= length2; j++) {
                if(i == 0 || j == 0) {
                    minDistanceCount[i][j] = Math.max(i, j);
                }
                else if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    minDistanceCount[i][j] = minDistanceCount[i - 1][j - 1];
                }
                else {
                    minDistanceCount[i][j] = 1 + Math.min(
                            minDistanceCount[i - 1][j - 1], //replace
                            Math.min(
                                    minDistanceCount[i][j - 1], //insert
                                    minDistanceCount[i - 1][j] //delete
                            )
                    );
                }
            }
        }

        return minDistanceCount[length1][length2];
    }
}
