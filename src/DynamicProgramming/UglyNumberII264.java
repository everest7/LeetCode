package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-05-15
 */

/**
 * Every time, we pick the smallest number from (1) - (3).
 * If the number is used, increment it by one
 * (1)num*2: 1x2,  2x2, 2x2, 3x2, 3x2, 4x2, 5x2...
 * (2)num*3: 1x3,  1x3, 2x3, 2x3, 2x3, 3x3, 3x3...
 * (3)num*5: 1x5,  1x5, 1x5, 1x5, 2x5, 2x5, 2x5...
 */
public class UglyNumberII264 {
    public static void main(String[] args) {
        UglyNumberII264 un = new UglyNumberII264();
        System.out.println(un.nthUglyNumber(10));
    }
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        int m2 = 0, m3 = 0, m5 = 0;
        for (int i = 1; i < n; i++) {
            int a = dp[m2] * 2;
            int b = dp[m3] * 3;
            int c = dp[m5] * 5;
            dp[i] = Math.min(a, Math.min(b, c));
            if (dp[i] == a) m2++;
            if (dp[i] == b) m3++;
            if (dp[i] == c) m5++;
        }
        return dp[n - 1];
    }
}
