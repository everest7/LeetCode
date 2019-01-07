package DynamicProgramming;

public class PaintHouse256 {
    public static void main(String[] args) {
        PaintHouse256 ph = new PaintHouse256();
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        int[][] costss = {{7,6,2}};
        System.out.println(ph.minCost(costs));

    }
    /*
    DP solution
    Reduce the 2 dimension array to three constants
     */
    public int minCost(int[][] costs){
        if (costs.length == 0) return 0;
        int lastR = costs[0][0];
        int lastB = costs[0][1];
        int lastG = costs[0][2];
        for (int i = 1; i < costs.length; i++){
            int curR = Math.min(lastB, lastG) + costs[i][0];
            int curB = Math.min(lastR, lastG) + costs[i][1];
            int curG = Math.min(lastR, lastB) + costs[i][2];
            lastR = curR;
            lastB = curB;
            lastG = curG;
        }
        return Math.min(lastR, Math.min(lastB, lastG));
    }

//    public int minCost(int[][] costs) {
//        if (costs.length == 0) return 0;
//        int len = costs.length;
//        int[][] dp = new int[len][3];
//        dp[0][0] = costs[0][0];
//        dp[0][1] = costs[0][1];
//        dp[0][2] = costs[0][2];
//        for (int i = 1; i < len; i++){
//            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
//            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
//            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
//        }
//        if (dp[len - 1][0] <= dp[len - 1][1] && dp[len - 1][0] <= dp[len - 1][2]){
//            return dp[len - 1][0];
//        } else if (dp[len - 1][1] <= dp[len - 1][0] && dp[len - 1][1] <= dp[len - 1][2]){
//            return dp[len - 1][1];
//        }else {
//            return dp[len - 1][2];
//        }
//
//    }
}
