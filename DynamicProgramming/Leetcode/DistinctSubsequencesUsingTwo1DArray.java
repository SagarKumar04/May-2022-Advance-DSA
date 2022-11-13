/*
Leetcode Link: https://leetcode.com/problems/distinct-subsequences/
 */

package DynamicProgramming.Leetcode;

public class DistinctSubsequencesUsingTwo1DArray {
    public int numDistinct(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();

        int previous[] = new int [lengthS + 1];
        int current[] = new int [lengthS + 1];

        for(int i = 0; i <= lengthS; i++) {
            previous[i] = 1;
        }

        for(int i = 1; i <= lengthT; i++) {
            for(int j = 1; j <= lengthS; j++) {
                if(t.charAt(i - 1) == s.charAt(j - 1)) {
                    current[j]
                            = previous[j - 1] //taking the current character from 's' into consideration
                            + current[j - 1]; //not taking the current character from 's' into consideration
                }
                else {
                    current[j] = current[j - 1]; //not taking the current character from 's' into consideratio
                }
            }

            for(int j = 0; j <= lengthS; j++) {
                previous[j] = current[j];
            }
        }

        return previous[lengthS];
    }
}
