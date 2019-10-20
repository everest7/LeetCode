package Graph;

/**
 * @author Vincent
 * @Date 2019-07-22
 */
public class LongestIncreasingPathinMatrix329 {
    public static void main(String[] args) {
        int[][] m = new int[][] {{9,9,4},
                {6,6,8},
                {2,1,1}};
        LongestIncreasingPathinMatrix329 lc = new LongestIncreasingPathinMatrix329();
        System.out.println(lc.longestIncreasingPath(m));
    }
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] == 0) {
                    dfs(matrix, i, j, dp, Integer.MIN_VALUE);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] m, int x, int y, int[][] dp, int prev) {
        if (x < 0 || y < 0 || x >= m.length || y >= m[0].length || m[x][y] <= prev) return 0;
        if (dp[x][y] != 0) return dp[x][y];
        int up = dfs(m, x - 1, y, dp, m[x][y]);
        int down = dfs(m, x + 1, y, dp, m[x][y]);
        int left = dfs(m, x, y - 1, dp, m[x][y]);
        int right = dfs(m, x, y + 1, dp, m[x][y]);
        dp[x][y] = 1 + Math.max(Math.max(left, right), Math.max(up, down));
        return dp[x][y];
    }

//    public int longestIncreasingPath(int[][] matrix) {
//        int rows = matrix.length, cols = matrix[0].length;
//        int[][] dp = new int[rows][cols];
//        int res = 0;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                res = Math.max(res, dfs(matrix, i, j, dp));
//            }
//        }
//        return res;
//    }
//
//    public int dfs(int[][] m, int x, int y, int[][] dp) {
//        if (dp[x][y] != 0) return dp[x][y];
//        int res = 1;
//        if (x > 0 && m[x][y] < m[x - 1][y]) res = Math.max(res, 1 + dfs(m, x - 1, y, dp));
//        if (x + 1 < m.length && m[x][y] < m[x + 1][y]) res = Math.max(res, 1 + dfs(m, x + 1, y, dp));
//        if (y > 0 && m[x][y] < m[x][y - 1]) res = Math.max(res, 1 + dfs(m, x, y - 1,dp));
//        if (y + 1 < m[0].length && m[x][y] < m[x][y + 1]) res = Math.max(res, 1 + dfs(m, x, y + 1, dp));
//        dp[x][y] = res;
//        return res;
//    }
}
