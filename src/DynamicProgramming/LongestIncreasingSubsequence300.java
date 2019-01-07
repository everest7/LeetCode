package DynamicProgramming;

public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] nums = {10};
        LongestIncreasingSubsequence300 lis = new LongestIncreasingSubsequence300();
        System.out.println(lis.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++){
            dp[i] = 1;
        }
        for (int j = 1; j < n; j++){
            for (int i = 0; i < j; i++){
                if (nums[i] < nums[j]){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            res = Math.max(res, dp[i]);
        }
        return res;

    }
}
