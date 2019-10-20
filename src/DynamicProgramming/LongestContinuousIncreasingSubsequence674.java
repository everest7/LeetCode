package DynamicProgramming;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 10/7/19
 */
public class LongestContinuousIncreasingSubsequence674 {
    public static void main(String[] args) {
//        System.out.println(findLengthOfLCISGapOne(new int[] {1,3,5,4,7}));
        System.out.println(findLengthOfLCISGapK(new int[] {1,3,5,4,2,7}, 2));
    }
    /**
     * Follow up2: two numbers can have a gap of size K
     */
    public static int findLengthOfLCISGapK(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = Math.max(0, i - k - 1); j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * Follow up1: two numbers can have a gap.
     * @param nums
     * @return
     */
    public static int findLengthOfLCISGapOne(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (i >= 2 && nums[i] > nums[i - 2]) {
                dp[i] = dp[i - 2] + 1;
            }
            if (nums[i] > nums[i - 1]){
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
