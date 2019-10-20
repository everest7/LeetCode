package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-07-10
 */
public class BurstBallons312 {
    public static void main(String[] args) {
        BurstBallons312 bb = new BurstBallons312();
        System.out.println(bb.maxCoins(new int[] {3,1,5,8}));
    }

    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        int len = nums.length;
        int[] bals = new int[len + 2];
        bals[0] = 1;
        bals[len + 1] = 1;
        for (int i = 1; i < len + 1; i++) {
            bals[i] = nums[i - 1];
        }
        int[][] dp = new int[len + 2][len + 2];
        for (int i = 1; i < len + 1; i++) {
            dp[i][i] = bals[i] * bals[i - 1] * bals[i + 1];
        }
        for (int j = 1; j < len + 2; j++) {
            for (int i = j - 1; i >= 0; i--) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + bals[i] * bals[k] * bals[j]);
                }
            }
        }
        return dp[0][len + 1];
    }

    /** DP
     * Define State:
     * dp[i][j] denotes the maximum coins from bursting balloons in [i + 1,j - 1] interval.
     *
     * Base Case:
     * dp[i][i] = A[i] * A[i-1] * A[i+1]
     *
     * Recurrence Relation:
     * dp[left][right] =
     *
     * @param nums
     * @return
     */
//    public int maxCoins(int[] nums) {
//        int len = nums.length;
//        int[] A = new int[len + 2];
//        for (int i = 0; i < len; i++) {
//            A[i + 1] = nums[i];
//        }
//        A[0] = 1;
//        A[len + 1] = 1;
//        int[][] dp = new int[len + 2][len + 2];
//        for (int dis = 2; dis < len + 2; dis++) {
//            for (int left = 0; left + dis < len + 2; left++) {
//                int right = left + dis;
//                for (int k = left + 1; k < right; k++) {
//                    dp[left][right] = Math.max(dp[left][right], A[k] * A[left] * A[right] + dp[left][k] + dp[k][right]);
//                }
//            }
//        }
//
//        return dp[0][len + 1];
//
//    }
}
