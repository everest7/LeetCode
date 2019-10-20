package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-06-22
 */
public class MinimumASCIIDeleteSumTwoStr712 {
    public static void main(String[] args) {

    }

    public int minimumDeleteSum(String s1, String s2) {
        char[] t1 = s1.toCharArray();
        char[] t2 = s2.toCharArray();
        int[][] dp = new int[t1.length + 1][t2.length + 1];
        for (int i = 1; i <= t1.length; i++) {
            dp[i][0] = dp[i - 1][0] + t1[i - 1];
        }
        for (int j = 1; j <= t2.length; j++) {
            dp[0][j] = dp[0][j - 1] + t2[j - 1];
        }
        for (int i = 1; i <= t1.length; i++) {
            for (int j = 1; j <= t2.length; j++) {
                if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + t1[i - 1], dp[i][j - 1] + t2[j - 1]);
                }
            }
        }
        return dp[t1.length][t2.length];
    }
}
