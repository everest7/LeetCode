package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-06-20
 */
public class PaintHouseII265 {
    public static void main(String[] args) {
        PaintHouseII265 ph = new PaintHouseII265();
        System.out.println(ph.minCostII(new int[][]{{1,5,3},{2,9,4}}));
    }

    /**
     * Track the first and second smallest cost in each row.
     * @param costs
     * @return
     */
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int[][] dp = new int[costs.length][costs[0].length];
        int min1 = -1;
        int min2 = -1;
        for (int i = 0; i < dp.length; i++) {
            int last1 = min1, last2 = min2;
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < dp[i].length; j++) {
                if (j != last1) {
                    dp[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else {
                    dp[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }
                if (min1 < 0 || costs[i][j] < dp[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || costs[i][j] < dp[i][min2]) {
                    min2 = j;
                }
            }
        }
        // return Math.min(dp[costs.length - 1][min1], dp[costs.length - 1][min2]);
        return dp[costs.length - 1][min1];
    }

//    public int minCostII(int[][] costs) {
//        if (costs.length == 0 || costs[0].length == 0) return 0;
//        int[][] dp = new int[costs.length + 1][costs[0].length];
//        for (int i = 1; i <= costs.length; i++) {
//            for (int j = 0; j < costs[0].length; j++) {
//                dp[i][j] = costs[i - 1][j] + findMin(dp[i - 1], j);
//            }
//        }
//        return findMin(dp[costs.length], -1);
//    }
//
//    public int findMin(int[] nums, int j) {
//        if (nums.length == 1) return nums[0];
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            if (i == j) continue;
//            if (min > nums[i]) {
//                min = nums[i];
//            }
//        }
//        return min;
//    }
}
