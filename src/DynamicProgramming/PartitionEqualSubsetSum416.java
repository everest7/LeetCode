package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-06-27
 */
public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        PartitionEqualSubsetSum416 pe = new PartitionEqualSubsetSum416();
        System.out.println(pe.canPartition(new int[] {1, 5, 11, 5}));
    }

    /**
     * State
     * dp[i][j] denotes whether sum j can be formed from the first i number
     *
     * Base case
     * dp[0][0]=True: zero numbers sum to zero is true
     *
     * Recurrence Relation
     * dp[i][j] = dp[i-1][j] || dp[i-1][j - A[i]] (Not choosing A[i] || choosing A[i])
     *
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        boolean[][] dp = new boolean [nums.length + 1][sum / 2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum / 2];
    }


//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        if (sum % 2 == 1) return false;
//        boolean[] dp = new boolean[sum / 2 + 1];
//        dp[0] = true;
//        for (int num : nums) {
//            for (int j = sum / 2; j >= num; j--) {
//                dp[j] = dp[j] || dp[j - num];
//            }
//        }
//        return dp[sum / 2];
//    }
}
