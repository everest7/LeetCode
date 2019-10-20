package DynamicProgramming;

public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence300 lis = new LongestIncreasingSubsequence300();
        System.out.println(lis.lengthOfLIS(nums));
    }

    /**
     * Follow up: Longest
     */

    /**
     * Dynamic Programming with Binary Search
     * Initialize a dp array, filled with 0;
     * Iterate each element in the 'nums'. Using binary search to look up if it is in dp array.
     * If the num > dp[last], extend the dp with num.
     * If num < dp[last], replace the dp[first greater position] with num.
     * Keep track of the size, return size as the result.
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int size = 1;
        for (int num : nums) {
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = num;
            if (left == size) {
                size++;
            }
        }
        return size;
    }
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++){
//            dp[i] = 1;
//        }
//        for (int j = 1; j < n; j++){
//            for (int i = 0; i < j; i++){
//                if (nums[i] < nums[j]){
//                    dp[j] = Math.max(dp[j], dp[i] + 1);
//                }
//            }
//        }
//        int res = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++){
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//
//    }
}
