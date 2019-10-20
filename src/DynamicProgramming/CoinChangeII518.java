package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-07-07
 */
public class CoinChangeII518 {
    public static void main(String[] args) {
        CoinChangeII518 cc = new CoinChangeII518();
        System.out.println(cc.change(8, new int[] {2,3,8}));
    }

    /**
     * State
     * dp[i][j] denotes the number of ways to make up amount j with the first i coins.
     *
     * Base case
     * dp[0][0] = 1 // One way to use 0 coin to make up $0
     * dp[0][1...m] = 0
     *
     * Recurrence Relation
     * dp[i][j] = sum{
     *     dp[i - 1][j] // not using coins[i - 1] at all
     *     dp[i - 1][j - coins[i - 1]] // using coins[i - 1] once
     *     dp[i - 1][j - coins[i - 1] * 2] // using coins[i - 1] twice
     *     ...
     * }
     * More formally,
     * dp[i][j] = sum{dp[i - 1][j - k * coins[i - 1]]} where 0 <= k <= j / coins[i - 1];
     *
     *
     */

    /**
     * @param amount: a total amount of money amount
     * @param coins: the denomination of each coin
     * @return: the number of combinations that make up the amount
     */
//    public int change(int amount, int[] coins) {
//        // write your code here
//        int[][] dp = new int[coins.length + 1][amount + 1];
//        dp[0][0] = 1;
//        for (int i = 1; i <= coins.length; i++) {
//            for (int j = 0; j <= amount; j++) {
//                dp[i][j] = 0;
//                for (int k = 0; k * coins[i - 1] <= j; k++) {
//                    dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
//                }
//            }
//        }
//        return dp[coins.length][amount];
//    }

    /**
     *
     * Recurrence Relation
     * dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
     *          Not using (i)th coin  +  Using (i)th coin, since we use ith coin here, $ = j - ($of ith coin)
     */
    public int change(int amount, int[] coins) {
        // write your code here
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
}
