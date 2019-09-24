package DynamicProgramming;

public class MaximumProductSubarray152 {
    public static void main(String[] args) {
        MaximumProductSubarray152 mp = new MaximumProductSubarray152();
        int[] nums = {2,-5,-2,-4,3};
        int[] nums2 = {-2, 0, -1};
        System.out.println(mp.maxProduct(nums));
    }

    /**
     * We use two arrays to keep track of the max and min product sum till current element(inclusive).
     * The maximum product must come from one of the following:
     * max[i - 1] * nums[i], min[i - 1] * nums[i], nums[i]
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int res = max[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(min[i - 1] * nums[i], nums[i]));
            res = Math.max(res, max[i]);
        }
        return res;
    }

//    public int maxProduct(int[] nums) {
//        if (nums.length == 0 || nums == null) return 0;
//        int min = nums[0], max = nums[0], res = nums[0];
//        for (int i = 1; i < nums.length; i++){
//            int temp = max;
//            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
//            min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
//            if (max > res){
//                res = max;
//            }
//        }
//        return res;
//    }
}
