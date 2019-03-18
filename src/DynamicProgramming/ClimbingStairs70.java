package DynamicProgramming;

/**
 * Review 2019-3-7
 */
public class ClimbingStairs70 {
    public static void main(String[] args) {
        ClimbingStairs70 cs = new ClimbingStairs70();
        System.out.println(cs.climbStairs(2));
    }

    /**
     * DP solution
     * Base case dp[0] = 1, dp[1] = 2, dp[3] = dp[1](climb two stairs this time) + dp[2](climb one stair this time)
     * Recurrence relation: dp[i] = dp[i - 1] + dp[i - 2]
     */
//    public int climbStairs(int n){
//        int[] res = new int[n + 1];
//        res[1] = 1;
//        res[2] = 2;
//        for (int i = 3; i <= n; i++){
//            res[i] = res[i - 1] + res[i - 2];
//        }
//        return res[n];
//
//    }

    /**
     * Brute force
     * Implementing recursion with bottom up
     */
//    public int climbStairs(int n) {
//        return count(0, n);
//    }
//    public int count(int i, int n){
//        if (i > n){
//            return 0;
//        }
//        if (i == n){
//            return 1;
//        }
//        return count(i + 1, n) + count(i + 2, n);
//    }

    /**
     * Recursion with memorization
     */
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return recursionMemo(0, n, memo);
    }

    public int recursionMemo(int start, int n, int[] memo) {
        if (start > n) return 0;
        if (start == n) return 1;
        if (memo[start] != 0) return memo[start];
        memo[start] = recursionMemo(start + 1, n, memo) + recursionMemo(start + 2, n, memo);
        return memo[start];
    }
}
