package DynamicProgramming;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-03-08
 */
public class MinimumCostForTickets983 {
    public static void main(String[] args) {
        MinimumCostForTickets983 mc = new MinimumCostForTickets983();
        System.out.println(mc.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2,7,15}));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int day : days) {
            dp[day] = 0;
        }
        dp[0] = 0;
        for (int i = 1; i <= 365; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = dp[i - 1];
            } else {
                int min = dp[i - 1] + costs[0];
                min = Math.min(min, dp[Math.max(0, i - 7)] + costs[1]);
                min = Math.min(min, dp[Math.max(0, i - 30)] + costs[2]);
                dp[i] = min;
            }
        }
        return dp[days[days.length - 1]];

    }
}
