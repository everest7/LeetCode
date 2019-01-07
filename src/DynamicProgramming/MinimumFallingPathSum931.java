package DynamicProgramming;

public class MinimumFallingPathSum931 {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MinimumFallingPathSum931 mf = new MinimumFallingPathSum931();
        System.out.println(mf.minFallingPathSum(A));
    }
    /*
    Using DP matrix
     */
    public int minFallingPathSum(int[][] A){
        int row = A.length;
        int col = A[0].length;
        int[][] dp = new int[row][col + 2];
        // copy the first row
        for (int j = 1; j <= col; j++){
            dp[0][j] = A[0][j - 1];
        }
        for (int i = 0; i < row; i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][col + 1] = Integer.MAX_VALUE;
        }
        // build the dp matrix
        for (int i = 1; i < row; i++){
            for (int j = 1; j < col + 1; j++){
                int minPrev = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                minPrev = Math.min(minPrev, dp[i - 1][j + 1]);
                dp[i][j] = minPrev + A[i][j - 1];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 1; j <= col; j++){
            res = Math.min(res, dp[row - 1][j]);
        }
        return res;
    }

    /*
    In place
     */
//    public int minFallingPathSum(int[][] A) {
//        int len = A.length;
//        for (int i = len - 2; i >= 0; i--){
//            for (int j = 0; j < A[0].length; j++){
//                if (j == 0){
//                    A[i][j] = Math.min(A[i + 1][j], A[i + 1][j + 1]) + A[i][j];
//                } else if (j == A[0].length - 1){
//                    A[i][j] = Math.min(A[i + 1][j], A[i + 1][j - 1]) + A[i][j];
//                } else {
//                    A[i][j] = Math.min(A[i + 1][j], Math.min(A[i + 1][j - 1], A[i + 1][j + 1])) + A[i][j];
//                }
//            }
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i = 0; i < A[0].length; i++){
//            if (res >= A[0][i]){
//                res = A[0][i];
//            }
//        }
//        return res;
//    }
}
