package Graph;
import java.util.*;
/**
 * @author Vincent
 * @Date 10/1/19
 */
public class NumberOfDistinctIslands694 {
    public static void main(String[] args) {
        int[][] grid= {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
//        int[][] grid={{1,1,0},{0,1,1},{0,0,0},{1,1,1},{0,1,0}};
        System.out.println(numDistinctIslands(grid));
    }

    public static int numDistinctIslands(int[][] grid) {
        if (grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder path = new StringBuilder();
                    dfs(i, j, grid, path, 0, 0);
                    set.add(path.toString());
                }
            }
        }
        return set.size();
    }

    static int[][] dirs = new int[][]{{1,0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void dfs(int x, int y, int[][] grid, StringBuilder path, int pos1, int pos2) {
        grid[x][y] = 0;
        path.append(pos1 + " " + pos2);
        path.append("/");
        for (int[] dir : dirs) {
            int nr = x + dir[0];
            int nc = y + dir[1];
            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                dfs(nr, nc, grid, path, pos1 + dir[0], pos2 + dir[1]);
            }
        }
    }
}
