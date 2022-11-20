/*
Leetcode Link: https://leetcode.com/problems/wildcard-matching/
 */

package DynamicProgramming.Leetcode;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();

        boolean matchArr[][] = new boolean[sLength + 1][pLength + 1];
        matchArr[0][0] = true;

        for(int i = 1; i <= sLength; i++) {
            matchArr[i][0] = false;
        }

        for(int i = 1; i <= pLength; i++) {
            if(!(p.charAt(i - 1) == '*')) {
                break;
            }
            matchArr[0][i] = true;
        }

        for(int i = 1; i <= sLength; i++) {
            for(int j = 1; j <= pLength; j++) {
                if(p.charAt(j - 1) != '*') {
                    /*
                    if(s.charAt(i - 1) == p.charAt(j - 1)) {
                        matchArr[i][j] = matchArr[i - 1][j - 1];
                    }
                    else if(p.charAt(j - 1) == '?') {
                        matchArr[i][j] = matchArr[i - 1][j - 1];
                    }
                    else {
                        matchArr[i][j] = false;
                    }
                    */
                    if(s.charAt(i - 1) == p.charAt(j - 1) || (p.charAt(j - 1) == '?')) {
                        matchArr[i][j] = matchArr[i - 1][j - 1];
                    }
                }
                else {
                    matchArr[i][j] = matchArr[i - 1][j] || matchArr[i][j - 1];
                }
            }
        }

        return matchArr[sLength][pLength];
    }
}
