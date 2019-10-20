package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-07-07
 * Lintcode 92
 *
 * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
 *
 */
public class Backpack92 {
    public static void main(String[] args) {
        Backpack92 bp = new Backpack92();
        System.out.println(bp.backPack(10, new int[] {3,4,8,5}));
    }

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int[] dp = new int[m + 1];
        for (int size : A) {
            // Must be filled from backward. Otherwise we may pick one item twice, dp[3] = dp[0] + 3, dp[6] = dp[3] + 3...
            for (int j = m; j >= size; j--) {
                dp[j] = Math.max(dp[j], dp[j - size] + size);
            }
        }
        return dp[m];
    }
}
