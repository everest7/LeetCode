package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-06-19
 */
public class UniquePath62 {
    public static void main(String[] args) {
        UniquePath62 up = new UniquePath62();
        System.out.println(up.uniquePaths(3, 2));
    }

    /**
     * TLE
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        return dfs(1, 1, n, m);
    }

    public int dfs(int x, int y, int n, int m) {
        if (x == n && y == m) return 1;
        if (x < 0 || y < 0 || x > n || y > m) return 0;
        return dfs(x + 1, y, n, m) + dfs(x, y + 1, n, m);
    }

//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[n][m];
//        // Initialize
//        for (int i = 0; i < n; i++) {
//            dp[i][0] = 1;
//        }
//        for (int j = 0; j < m; j++) {
//            dp[0][j] = 1;
//        }
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//        return dp[n - 1][m - 1];
//    }
}
