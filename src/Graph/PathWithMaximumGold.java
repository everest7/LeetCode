package Graph;

/**
 * @author Vincent
 * @Date 10/5/19
 */
public class PathWithMaximumGold {
    public static void main(String[] args) {

    }

    public int getMaximumGold(int[][] grid) {

        int rows = grid.length, cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    int[] max = new int[1];
                    dfs(i, j, grid, new boolean[rows][cols], max, 0);
                    res = Math.max(max[0], res);
                }
            }
        }
        return res;
    }

    public void dfs(int x, int y, int[][] m, boolean[][] visited, int[] temp, int curSum) {
        if (x < 0 || y < 0 || x >= m.length || y >= m[0].length || visited[x][y] || m[x][y] == 0) return;
        visited[x][y] = true;
        curSum += m[x][y];
        temp[0] = Math.max(temp[0], curSum);
        dfs(x + 1, y, m, visited, temp, curSum);
        dfs(x - 1, y, m, visited, temp, curSum);
        dfs(x, y + 1, m, visited, temp, curSum);
        dfs(x, y - 1, m, visited, temp, curSum);
        curSum -= m[x][y];
        visited[x][y] = false;
    }
}
