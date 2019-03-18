package DynamicProgramming;

public class MinimumPathSum64 {
    public static void main(String[] args) {
        int[][] nums = {{1,3,1}, {1,5,1}, {4,2,1}};
        MinimumPathSum64 mp = new MinimumPathSum64();
        System.out.println(mp.minPathSum(nums));

    }
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = row - 1; i >= 0; i--){
            for (int j = col - 1; j >= 0; j--){
                if (i == row - 1 && j != col - 1){
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (i != row - 1 && j == col - 1){
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i != row - 1 && j != col - 1){
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
}
