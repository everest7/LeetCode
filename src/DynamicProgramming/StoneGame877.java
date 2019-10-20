package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-08-28
 */
public class StoneGame877 {
    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{5, 3, 4, 5}));
    }

    /**
     * Bottom up DP
     * dp[i][j] denotes the scores Alex(first player) has more than Lee from interval [i:j]
     * @param piles
     * @return
     */
    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }

    /**
     * Recursion with memo
     * dp[i][j] denotes the scores Alex(first player) has more than Lee from interval [i:j]
     * Alex's turn
     * dp[i][j] = Math.max(dp[low + 1][high] + piles[low], dp[low][high - 1] + piles[high]);
     *            Take the first stone                      take the last stone
     * Lee's turn, subtract from Alex's score
     * dp[i][j] = Math.max(dp[low + 1][high] - piles[low], dp[low][high - 1] - piles[high]);
     *                  Take the first stone                      take the last stone
     * @param piles
     * @return
     */
//    public static boolean stoneGame(int[] piles) {
//        int n = piles.length;
//        int[][] dp = new int[n][n];
//        return calculate(dp, 0, n - 1, piles) > 0;
//    }
//
//    public static int calculate(int[][] dp, int low, int high, int[] piles) {
//        if (low == high) return 0;
//        if (dp[low][high] != 0) return dp[low][high];
//        int res = 0;
//        if ((low + high + 1) % 2 == 0) { // Alex's turn
//            res = Math.max(dp[low + 1][high] + piles[low], dp[low][high - 1] + piles[high]);
//        } else { // Lee's turn
//            res = Math.max(dp[low + 1][high] - piles[low], dp[low][high - 1] - piles[high]);
//        }
//        dp[low][high] = res;
//        return res;
//    }
}
