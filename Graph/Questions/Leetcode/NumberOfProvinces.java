/*
Leetcode Link: https://leetcode.com/problems/number-of-provinces/
 */

package Graph.Questions.Leetcode;

public class NumberOfProvinces {
    private void findCircleNumHelper(int[][] isConnected, int currentCity) {
        for(int j = 0; j < isConnected.length; j++) {
            if(isConnected[currentCity][j] == 1) {
                isConnected[currentCity][j] = isConnected[j][currentCity] = 0;
                findCircleNumHelper(isConnected, j);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int count = 0;

        for(int i = 0; i < isConnected.length; i++) {
            if(isConnected[i][i] == 1) {
                findCircleNumHelper(isConnected, i);
                count++;
            }
        }

        return count;
    }
}
