/*
Leetcode Link: https://leetcode.com/problems/flood-fill/
 */

package Graph.Questions.Leetcode;

public class FloodFill {
    public void floodFillHelper(int[][] image, int row, int column, int previousColor, int newColor) {
        if(row < 0
        || row >= image.length
        || column < 0
        || column >= image[0].length
        || image[row][column] != previousColor) {
            return;
        }

        image[row][column] = newColor;

        floodFillHelper(image, row - 1, column, previousColor, newColor); //up
        floodFillHelper(image, row, column + 1, previousColor, newColor); //right
        floodFillHelper(image, row + 1, column, previousColor, newColor); //down
        floodFillHelper(image, row, column - 1, previousColor, newColor); //left
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] != color) {
            floodFillHelper(image, sr, sc, image[sr][sc], color);
        }

        return image;
    }
}
