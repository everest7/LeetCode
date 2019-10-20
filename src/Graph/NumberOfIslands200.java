package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vincent
 * @Date 2019-03-24
 */
public class NumberOfIslands200 {
    public static void main(String[] args) {
        NumberOfIslands200 ns = new NumberOfIslands200();
        char[][] island = {{'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}};
        System.out.println(ns.numIslands(island));
    }

    /**
     * BFS
     * Linear search the array
     */
//    public int numIslands(char[][] grid) {
//        if (grid.length == 0 || grid[0].length == 0) return 0;
//        int row = grid.length;
//        int col = grid[0].length;
//        int res = 0;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                Queue<Integer> queue = new LinkedList<>();
//                if (grid[i][j] == '1') {
//                    res++;
//                    grid[i][j] = '0';
//                    queue.offer(i * col + j);
//                }
//                while (!queue.isEmpty()) {
//                    int num = queue.poll();
//                    int nr = num / col;
//                    int nc = num % col;
//                    if (nr - 1 >= 0 && grid[nr - 1][nc] == '1') {
//                        queue.offer((nr - 1) * col + nc);
//                        grid[nr - 1][nc] = '0';
//                    }
//                    if (nc - 1 >= 0 && grid[nr][nc - 1] == '1') {
//                        queue.offer(nr * col + nc - 1);
//                        grid[nr][nc - 1] = '0';
//                    }
//                    if (nr + 1 < row && grid[nr + 1][nc] == '1') {
//                        queue.offer((nr + 1) * col + nc);
//                        grid[nr + 1][nc] = '0';
//                    }
//                    if (nc + 1 < col && grid[nr][nc + 1] == '1') {
//                        queue.offer(nr * col + nc + 1);
//                        grid[nr][nc + 1] = '0';
//                    }
//                }
//            }
//        }
//        return res;
//    }

    /**
     * DFS
     * @param grid
     * @return
     */
//    public int numIslands(char[][] grid) {
//        int row = grid.length;
//        int col = grid[0].length;
//        int res = 0;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                res += grid[i][j] - '0';
//                dfs(grid, i, j , row, col);
//            }
//        }
//        return res;
//    }
//
//    public void dfs(char[][] grid, int i, int j, int row, int col) {
//        // Base case
//        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0') return;
//        grid[i][j] = '0';
//        dfs(grid, i + 1, j, row, col);
//        dfs(grid, i - 1, j, row, col);
//        dfs(grid, i, j + 1, row, col);
//        dfs(grid, i, j - 1, row, col);
//    }

    private int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; i < cols; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }
        return res;
    }

    public void dfs(int i, int j, char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            dfs(i + dir[k][0], j + dir[k][1], grid);
        }
    }
}
