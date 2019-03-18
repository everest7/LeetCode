package DynamicProgramming;

public class HouseRobberII213 {
    public static void main(String[] args) {
        HouseRobberII213 hr = new HouseRobberII213();
        int[] nums = {1, 2, 3, 1};
        System.out.println(hr.rob(nums));

    }
    /*
    Using constants to replace array
     */
    public int rob(int[] nums){
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int rob1 = 0, rob2 = 0;
        int sum1 = 0, sum2 = 0;
        // Start robbing from house 1
        for (int i = 0; i < nums.length - 1; i++){
            sum1 = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = sum1;
        }
        rob1 = 0;
        rob2 = 0;
        for (int i = 1; i < nums.length; i++){
            sum2 = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = sum2;
        }
        return Math.max(sum1, sum2);
    }

    /*
    Modified version from House RobberI
     */
//    public int rob(int[] nums) {
//        if (nums.length == 0) return 0;
//        if (nums.length == 1) return nums[0];
//        int[] dp = new int[nums.length];
//        int[] dp2 = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = nums[1];
//        dp2[0] = 0;
//        dp2[1] = nums[1];
//        for (int i = 2; i < nums.length - 1; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//        }
//        for (int j = 2; j < nums.length; j++){
//            dp2[j] = Math.max(dp2[j - 2] + nums[j], dp2[j - 1]);
//        }
//
//        return Math.max(dp[nums.length - 1], dp2[nums.length - 1]);
//    }
}
