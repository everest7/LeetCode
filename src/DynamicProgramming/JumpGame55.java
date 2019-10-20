package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-07-25
 */
public class JumpGame55 {
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,1,4};
        JumpGame55 jg = new JumpGame55();
        System.out.println(jg.canJump(nums));
    }

    /**
     * DP
     * boolean dp[nums.length] where dp[i] denotes whether we can jump to the ith position
     *
     * Base case:
     * dp[0] = true
     *
     * Recurrence Relation
     * j = (1, ..., nums[i])
     * dp[i + j] = dp[i]
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; i + j < nums.length && j <= nums[i]; j++) {
                dp[i + j] = dp[i];
            }
        }
        return dp[nums.length - 1];
    }
}
