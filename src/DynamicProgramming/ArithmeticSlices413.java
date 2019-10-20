package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-06-27
 */
public class ArithmeticSlices413 {
    public static void main(String[] args) {
        ArithmeticSlices413 as = new ArithmeticSlices413();
        System.out.println(as.numberOfArithmeticSlices(new int[] {1, 2, 3, 4}));
    }

    /**
     * Use 1D array dp[i] to store the number of arithmetic slices can form ending with number A[i]
     * Sum up all values in A[i] to get the result
     */
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        int[] dp = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            if (A[i] + A[i - 2] == 2 * A[i - 1]) {
                dp[i] = 1 + dp[i - 1];
            }
            res += dp[i];
        }
        return res;
    }

    /**
     * Use 2D boolean array dp[i][j] to represent whether A[i:j] is arithmetic slices,
     * return the total number of true value in dp array as result
     */
//    public int numberOfArithmeticSlices(int[] A) {
//        int len = A.length;
//        boolean[][] dp = new boolean[A.length][A.length];
//        int res = 0;
//        for (int j = 1; j < len; j++) {
//            for (int i = 0; i < j; i++) {
//                if (j - i < 2) continue;
//                if (j - i == 2 && A[i] + A[j] == 2 * A[i + 1]) {
//                    dp[i][j] = true;
//                } else {
//                    dp[i][j] = dp[i][j - 1] && (A[j] + A[j - 2] == 2 * A[j - 1]);
//                }
//                res += dp[i][j] ? 1 : 0;
//            }
//        }
//        return res;
//    }
}
