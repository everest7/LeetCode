package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-06-21
 */
public class PerfectSquares279 {
    public static void main(String[] args) {
        PerfectSquares279 ps = new PerfectSquares279();
        System.out.println(ps.numSquares(12));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 0; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
