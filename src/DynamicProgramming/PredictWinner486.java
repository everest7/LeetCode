package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-09-03
 */
public class PredictWinner486 {
    public static void main(String[] args) {
//        System.out.println(PredictTheWinner(new int[] {1, 5, 233, 7}));
        System.out.println(PredictTheWinner(new int[] {1, 5, 2}));
    }

    /**
     * State
     * dp[i][j] denotes the maximum score the current player can get from A[i:j]
     *
     * Base case:
     * dp[i][i] = A[i];
     * dp[i][i + 1] = max{A[i], A[i + 1]}
     *
     * Recurrence Relation
     * for current player, we can choose the first item A[i] or the last item A[j]
     * dp[i][j] = max{A[i] + min{dp[i + 1][j - 1], dp[i + 2][j]},
     *                A[j] + min{dp[i][j - 2], dp[i + 1][j - 1]}}
     * @param nums
     * @return
     */
//    public static boolean PredictTheWinner(int[] nums) {
//        int[][] dp = new int[nums.length][nums.length];
//        int sum = 0, n = nums.length;
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//            dp[i][i] = nums[i];
//        }
//        for (int i = 0; i < n - 1; i++) {
//            dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
//        }
//        for (int len = 2; len < n; len++){
//            for (int i = 0; i < n - len; i++) {
//                int j = i + len;
//                dp[i][j] = Math.max(nums[i] + Math.min(dp[i + 1][j - 1], dp[i + 2][j]),
//                        nums[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]));
//
//            }
//        }
//        return dp[0][n - 1] > sum / 2;
//    }


    /**
     * Viewing player2 scoring as deducting points from player1
     * @param nums
     * @return
     */
    public static boolean PredictTheWinner(int[] nums) {
        int n = nums.length, sum = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            dp[i][i] = nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
        }
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
