//Backtracking

/*
    Time Complexity : O(N!)
    Space Complexity : O(N^2)
    
    Where N is the number of queens.
*/

import java.util.ArrayList;

public class Solution {
    static private boolean isSafe(int[][] board, int row, int col, int n) {
        int i;
        int j;

        // Check this coloumn.
        for (i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper-left diagonal.
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper-right diagonal.
        for (i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    static private void addSolution(int[][] board, int n, ArrayList < ArrayList < Integer >> ans) {
        ArrayList < Integer > currentAnswer = new ArrayList < > ();

        for (int[] row: board) {
            for (int element: row) {
                currentAnswer.add(element);
            }
        }

        ans.add(currentAnswer);
    }

    static private void solveNQueensHelper(int[][] board, int row, int n, ArrayList < ArrayList < Integer >> ans) {
        if (row >= n) {
            addSolution(board, n, ans);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, row, i, n)) {

                board[row][i] = 1;
                solveNQueensHelper(board, row + 1, n, ans);
                board[row][i] = 0;

            }
        }
    }

    public static ArrayList < ArrayList < Integer >> solveNQueens(int n) {
        int[][] board = new int[n][n];
        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();
        solveNQueensHelper(board, 0, n, ans);
        return ans;
    }
}

