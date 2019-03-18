package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange322 {
    public static void main(String[] args) {
        CoinChange322 cc = new CoinChange322();
        System.out.println(cc.coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(cc.coinChange(new int[]{186,419,83,408}, 6249));
//        System.out.println(cc.coinChange(new int[]{1}, 0));

    }
    /**
     * Top down
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        return coinChangeDFS(coins, amount, dp);
    }

    public int coinChangeDFS(int[] coins, int target, int[] memo) {
        if (target < 0) return -1;
        if (memo[target] != Integer.MAX_VALUE) {
            return memo[target];
        }
        for (int coin : coins) {
            int temp = coinChangeDFS(coins, target - coin, memo);
            if (temp >= 0) {
                memo[target] = Math.min(memo[target], temp + 1);
            }
        }
        return memo[target] = memo[target] == Integer.MAX_VALUE ? -1 : memo[target];
    }

    /**
     * Bottom up
     */
//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp,amount + 1);
//        dp[0] = 0;
//        for (int i = 1; i < amount + 1; i++) {
//            for (int num : coins) {
//                if (i - num >= 0) {
//                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
//                }
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];
//    }
}
