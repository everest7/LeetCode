package DynamicProgramming;

public class BestTimetoBuyandSellStock121 {
    public static void main(String[] args) {
        BestTimetoBuyandSellStock121 bt = new BestTimetoBuyandSellStock121();
        int[] prices = {1,2};
        int[] prices2 = {7,6,4,3,1};
        System.out.println(bt.maxProfit(prices));
        System.out.println(bt.maxProfit(prices2));
    }
    /*
    Same logic as finding the largest sum of subarray
     */
    public  int maxProfit(int[] prices){
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++){
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    /*
    Convert the problem into finding the largest sum of subarray
    7, 1, 5, 3, 6, 4
     -6 4  -2  3  -2
     The maximum sum of subarray is 5 = 4 + -2 + 3
     */
//    public int maxProfit(int[] prices){
//        if (prices.length < 2) return 0;
//        int[] profit = new int[prices.length - 1];
//        for (int i = 0; i < prices.length - 1; i++){
//            profit[i] = prices[i + 1] - prices[i];
//        }
//        return Math.max(0, maxSubArray(profit));
//    }
//    public int maxSubArray(int[] nums){
//        int[] f = new int[nums.length];
//        f[0] = nums[0];
//        int maxSum = f[0];
//        for (int i = 1; i < nums.length; i++){
//            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
//            maxSum = Math.max(f[i], maxSum);
//        }
//        return maxSum;
//    }

    /*
    DP: Use minPrice to track the minimum price of the stock, which occurs before
    selling. Use maxProfit to calculate thr profit if sell stock at that day, choose
    the max profit and return it.
     */
//    public int maxProfit(int[] prices){
//        int minPrice = Integer.MAX_VALUE;
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length; i++){
//            minPrice = Math.min(minPrice, prices[i]);
//            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
//        }
//        return maxProfit;
//    }

    // Brute force
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length - 1; i++){
//            for (int j = i + 1; j < prices.length; j++){
//                int profit = prices[j] - prices[i];
//                if (profit > maxProfit){
//                    maxProfit = profit;
//                }
//            }
//        }
//        return maxProfit;
//    }
}
