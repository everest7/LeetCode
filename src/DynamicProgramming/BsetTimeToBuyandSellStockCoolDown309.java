package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-06-27
 */
public class BsetTimeToBuyandSellStockCoolDown309 {
    public static void main(String[] args) {

    }

    /**
     * Define state
     * hold[i] means you have one stock in your hand at the end of (i)th day.
     * unhold[i] means you have zero stock in your hand at the end of (i)th day.
     *
     * Base case, initially you have 0 money
     * hold[0] = -prices[0] you bought the first stock, currently you have -prices[0] money
     * hold[1] = you choose to buy either the first or the second stock, it depends on which stock is cheaper
     * unhold[0] = 0, you choose not to buy the first stock, you still have 0 money in hand
     *
     * Recurrence Relation
     * At the end of ith day, you have stock in hand, that means you either have stock in i-1 day or you bought
     * a stock in ith day. Since market has one day cool down, you accumulate the profit since the last sell.
     * hold[i] = max{hold[i - 1], unhold[i - 2] - prices[i]}
     *
     * At the end of ith day, you have no stock in hand, that means you either have no stock in i-1 day or you
     * sold the stock in ith day.
     * unhold[i] = max{unhold[i - 1], hold[i - 1] + prices[i]}
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        // Define state
        int[] hold = new int[prices.length];
        int[] unhold = new int[prices.length];
        // Base case
        hold[0] = -prices[0];
        unhold[0] = 0;
        // Recurrence relation
        for (int i = 1; i < prices.length; i++) {
            if (i == 1) {
                hold[i] = Math.max(-prices[1], -prices[0]);
            } else {
                hold[i] = Math.max(hold[i - 1], unhold[i - 2] - prices[i]);
            }
            unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i]);
        }
        return unhold[prices.length - 1];
    }
}
