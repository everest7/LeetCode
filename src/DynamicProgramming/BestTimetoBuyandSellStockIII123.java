package DynamicProgramming;

public class BestTimetoBuyandSellStockIII123 {
    /**
    Design an algorithm to find the maximum profit. You may complete at most two transactions.
     */
    public static void main(String[] args) {
        BestTimetoBuyandSellStockIII123 bt = new BestTimetoBuyandSellStockIII123();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(bt.maxProfit(prices));

    }

    /**
     * dp[k][i] represents the maximal profit for kth transaction at the ith day.
     */
//    public int maxProfit(int[] prices) {
//        if (prices.length == 0) return 0;
//        int len = prices.length;
//        int[][] dp = new int[3][len];
//        for (int k = 1; k <= 2; k++) {
//            for (int i = 1; i < len; i++) {
//                int min = prices[0];
//                for (int j = 1; j <= i; j++) {
//                    min = Math.min(min, prices[j] - dp[k - 1][j - 1]);
//                }
//                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
//            }
//        }
//        return dp[2][len - 1];
//    }

    /**
     * min is repeatedly calculated in above case, we can eliminated the most nested for loop
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int len = prices.length;
        int[][] dp = new int[3][len];
        for (int k = 1; k <= 2; k++) {
            int min = prices[0];
            for (int i = 1; i < len; i++) {
                min = Math.min(min, prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }
        return dp[2][len - 1];
    }
}
