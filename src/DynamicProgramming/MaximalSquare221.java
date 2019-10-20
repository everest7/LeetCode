package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-06-22
 */
public class MaximalSquare221 {
    public static void main(String[] args) {
        int[][] mat = new int[][] {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        MaximalSquare221 ms = new MaximalSquare221();
        System.out.println(ms.maximalSquare(mat));
    }
    public int maximalSquare(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int res = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}
