/*
Leetcode Link: https://leetcode.com/problems/unique-paths/
 */

package DynamicProgramming.Leetcode;

public class UniquePathsWithoutArray {
    public int uniquePaths(int m, int n) {
        m = m - 1; //m--;
        n = n - 1; //n--;

        //consider 'm' as greater among 'm' and 'n'
        if(m < n) {
            //swap
            m = m + n;
            n = m - n;
            m = m - n;
        }

        int result = 1;
        for(int i = (m + 1), j = 1; i <= (m + n); i++, j++) {
            result = result * i;
            result = result / j;
        }

        return result;
    }
}
