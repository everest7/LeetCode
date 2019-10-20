package DynamicProgramming;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-07-09
 */
public class CombinationSumIV377 {
    public static void main(String[] args) {
        CombinationSumIV377 cs = new CombinationSumIV377();
        System.out.println(cs.combinationSum4(new int[] {1, 2, 3}, 4));
    }

    /**
     * Recursion with memoization
     */
//    int[] dp;
//    public int combinationSum4(int[] nums, int target) {
//        dp = new int[target + 1];
//        Arrays.fill(dp, -1);
//        dp[0] = 1;
//        return helper(nums, target);
//
//    }
//
//    public int helper(int[] nums, int target) {
//        if (dp[target] != -1) {
//            return dp[target];
//        }
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (target >= nums[i]) {
//                res += helper(nums, target - nums[i]);
//            }
//        }
//        dp[target] = res;
//        return res;
//    }

    /**
     * Bottom up DP
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
