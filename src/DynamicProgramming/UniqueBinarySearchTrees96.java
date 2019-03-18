package DynamicProgramming;

public class UniqueBinarySearchTrees96 {
    public static void main(String[] args) {
        UniqueBinarySearchTrees96 ub = new UniqueBinarySearchTrees96();
        System.out.println(ub.numTrees(3));
    }

    /**
     * dp[0] = 1, dp[1] = 1
     * dp[2] = dp[0] * dp[1] + dp[1] * dp[0] = root 1 + root 2
     * dp[3] = dp[0] * dp[2] + dp[1] * dp[1] + dp[2] * dp[0] = root 1 + root 2 + root "3"
     * ...
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
