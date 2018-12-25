package DynamicProgramming;

public class BestTimetoBuyandSellStockII122 {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockII122 bt = new BestTimetoBuyandSellStockII122();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(bt.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i - 1]){
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
