package Graph;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-08-06
 */
public class SurroundedRegion130 {
    public static void main(String[] args) {
        char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    /**
     * DFS
     * @param board
     */
    public static void solve(char[][] board) {
        if (board.length < 2 || board[0].length < 2) return;
        int rows = board.length, cols = board[0].length;
        if (rows < 2 || cols < 2) return;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }
        if (i > 1 && board[i - 1][j] == 'O') dfs(board, i - 1, j);
        if (j > 1 && board[i][j - 1] == 'O') dfs(board, i, j - 1);
        if (i + 1 < board.length - 1 && board[i + 1][j] == 'O') dfs(board, i + 1, j);
        if (j + 1 < board[0].length - 1 && board[i][j + 1] == 'O') dfs(board, i, j + 1);

    }
}
