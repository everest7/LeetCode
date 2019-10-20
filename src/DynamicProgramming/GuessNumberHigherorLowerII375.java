package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-08-21
 */
public class GuessNumberHigherorLowerII375 {
    public static void main(String[] args) {
        System.out.println(getMoneyAmount(10));
    }

    /**
     * Define state:
     * Since we need to guarantee a win, we need to assume that every time we pick the worst number
     * dp[i][j] denotes the minimum cost of finding the worst number in range (i, j)
     *
     * Base case:
     * dp[i][i] = 0, when there is only one number, we'll get the right number directly without paying cost
     * dp[i][i + 1] = i, when there are two numbers, we can guess one time to get the right number, the minimum
     * cost is to guess the smaller number(cost)
     *
     * Recurrence relation:
     * dp[i][j] = k + max{dp[i][k - 1], dp[k + 1][j]} // k is the number we chose, dp[i][k - 1] or dp[k + 1][j] is
     * the worst sub problem
     * There are i < k < j such options, we need to choose the minimum cost choosing the worst number
     * dp[i][j] = min{k + max{dp[i][k - 1], dp[k + 1][j]}} where i < k < j
     *
     * Using min{} and max{} means your strategy is best, but you have to prepare for the worst
     * k + max{dp[i][k - 1], dp[k + 1][j]} after pick k, there are two range: [i, k-1] and [k + 1, j], you don't know
     * which one to choose, but in order to guarantee a win, you need to prepare for the worst, therefore you choose
     * the maximum of the two
     *
     * @param n
     * @return
     */
    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            dp[i][i + 1] = i;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int cost = Integer.MAX_VALUE;
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    cost = Math.min(cost, k + Math.max((k - 1 >= i ? dp[i][k - 1] : 0), (k + 1 <= j ? dp[k + 1][j] : 0)));
                }
                dp[i][j] = cost;
            }
        }
        return dp[1][n];
    }

//    public static int getMoneyAmount(int n) {
//        if(n == 1) return 0;
//        if(n == 2) return 1;
//
//        int[][] dp = new int[n + 1][n + 1];
//        for(int i = 1; i <= n; i++) {
//            dp[i][i] = 0; // range(i, i)
//        }
//        for(int i = 1; i < n; i++) {
//            dp[i][i + 1] = i; // range(i, i + 1)
//        }
//        for(int len = 3; len <= n; len++) {
//            for (int i = 1; i <= n - len + 1; i++) {
//                int cost = Integer.MAX_VALUE;
//                int j = i + len - 1;
//                for(int pivot = i; pivot <= j; pivot++) {
//                    cost = Math.min(cost, pivot + Math.max((pivot - 1 >= i ? dp[i][pivot - 1] : 0), (pivot + 1 <= j ? dp[pivot + 1][j] : 0)));
//                }
//                dp[i][j] = cost;
//            }
//        }
//        return dp[1][n];
//    }
}
