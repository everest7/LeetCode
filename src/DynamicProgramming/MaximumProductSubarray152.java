package DynamicProgramming;

public class MaximumProductSubarray152 {
    public static void main(String[] args) {
        MaximumProductSubarray152 mp = new MaximumProductSubarray152();
        int[] nums = {2,3,-2,4};
        int[] nums2 = {-2, 0, -1};
        System.out.println(mp.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int min = nums[0], max = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++){
            int temp = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
            if (max > res){
                res = max;
            }
        }
        return res;
    }
}
