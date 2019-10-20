package Backtracking;

/**
 * @author Vincent
 * @Date 2019-06-08
 */
public class WordSearch79 {
    public static void main(String[] args) {
        WordSearch79 ws = new WordSearch79();
        char[][] words = new char[][] {{'a'}};
        System.out.println(ws.exist(words, "a"));
    }

    private int[][] dir = new int[][] {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        if (board.length == 0) return false;
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, board, visited, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, boolean[][] visited, int idx, String word) {
        if (idx == word.length()) return true;
        int rows = board.length, cols = board[0].length;
        for (int k = 0; k < 4; k++) {
            int rr = i + dir[k][0], cc = j + dir[k][1];
            if (rr < 0 || cc < 0 || rr >= rows || cc >= cols || board[rr][cc] != word.charAt(idx) || visited[rr][cc]) continue;
            visited[rr][cc] = true;
            if (dfs(rr, cc, board, visited, idx + 1, word)) {
                return true;
            }
            visited[rr][cc] = false;
        }
        return false;
    }

//    public boolean exist(char[][] board, String word) {
//        if (word == null || word.length() == 0) return false;
//        int row = board.length, col = board[0].length;
//        boolean[][] visited = new boolean[row][col];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (dfs(board, 0, word, i, j, row, col, visited)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public boolean dfs(char[][] board, int idx, String word, int i, int j, int row, int col, boolean[][] visited) {
//        if (idx == word.length()) {
//            return true;
//        }
//        if (i < 0 || j < 0 || i >= row || j >= col || board[i][j] != word.charAt(idx)) return false;
//        visited[i][j] = true;
//        boolean search = dfs(board, idx + 1, word, i + 1, j, row, col, visited)
//                || dfs(board, idx + 1, word, i - 1, j, row, col, visited)
//                || dfs(board, idx + 1, word, i, j + 1, row, col, visited)
//                || dfs(board, idx + 1, word, i, j - 1, row, col, visited);
//        visited[i][j] = false;
//        return search;
//    }
}
