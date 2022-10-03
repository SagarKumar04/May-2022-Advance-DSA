/*
Leetcode Link: https://leetcode.com/problems/surrounded-regions/
 */

package Graph.Questions.Leetcode;

public class SurroundedRegions {
    private void solveHelper(char board[][], int x, int y) {
        if(x < 0
        || x >= board.length
        || y < 0
        || y >= board[0].length
        || board[x][y] != 'O') {
            return;
        }

        board[x][y] = '*';

        solveHelper(board, x - 1, y); //up
        solveHelper(board, x, y + 1); //right
        solveHelper(board, x + 1, y); //down
        solveHelper(board, x, y - 1); //left
    }

    public void solve(char[][] board) {
        int rowCount = board.length;
        int columnCount = board[0].length;

        if (rowCount <= 2 || columnCount <= 2) {
            return;
        }

        //first row and last row
        for (int i = 0; i < columnCount; i++) {
            if (board[0][i] == 'O') {
                //dfs
                solveHelper(board, 0, i);
            }
            if (board[rowCount - 1][i] == 'O') {
                //dfs
                solveHelper(board, rowCount - 1, i);
            }
        }

        //first column and last column
        for (int i = 1; i < rowCount - 1; i++) {
            if (board[i][0] == 'O') {
                //dfs
                solveHelper(board, i, 0);
            }
            if (board[i][columnCount - 1] == 'O') {
                //dfs
                solveHelper(board, i, columnCount - 1);
            }
        }

        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < columnCount; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if(board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
