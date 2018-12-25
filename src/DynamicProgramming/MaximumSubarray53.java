package DynamicProgramming;

public class MaximumSubarray53 {
    public static void main(String[] args) {
        MaximumSubarray53 ms = new MaximumSubarray53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums1 = {-1, -2};
//        System.out.println(ms.maxSubArray(nums));
        System.out.println(ms.maxSubArray(nums1));

    }
    /*
    DP
     */
    public int maxSubArray(int[] nums){
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++){
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(f[i], maxSum);
        }
        return maxSum;
    }


//    public int maxSubArray(int[] nums) {
//        if (nums == null) return 0;
//        int maxSum = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++){
//            int sum = 0;
//            for (int j = 1; j <= nums.length; j++){
//                if (i + j > nums.length){
//                    break;
//                }
//                sum += nums[i + j - 1];
//                maxSum = Math.max(maxSum, sum);
//            }
//        }
//        return maxSum;
//    }
}
