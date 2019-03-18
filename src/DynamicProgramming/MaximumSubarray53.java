package DynamicProgramming;

public class MaximumSubarray53 {
    public static void main(String[] args) {
        MaximumSubarray53 ms = new MaximumSubarray53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums1 = {-1, -2};
        System.out.println(ms.maxSubArray(nums));
        System.out.println(ms.maxSubArray(nums1));

    }

    /*
    Divide and conquer
     */
    public int maxSubArray(int[] nums){
        int max = Integer.MIN_VALUE;
        return maxArray(nums, 0, nums.length - 1, max);
    }
    public int maxArray(int[] nums, int left, int right, int max){
        if (left > right){
            return Integer.MIN_VALUE;
        }
        int mid = (left + right) / 2;
        // The max subarray interval lies in A[left: mid - 1]
        int l = maxArray(nums, left, mid - 1, max);
        // The max subarray interval lies in A[mid + 1: right]
        int r = maxArray(nums, mid + 1, right, max);
        max = Math.max(max, Math.max(l, r));
        // The max subarray cross the mid index
        int sum = 0, lmax = 0, rmax = 0;
        for (int i = mid - 1; i >=left; i--){
            sum += nums[i];
            if (sum > lmax){
                lmax = sum;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= right; j++){
            sum += nums[j];
            if (sum > rmax){
                rmax = sum;
            }
        }
        max = Math.max(max, rmax + lmax + nums[mid]);
        return max;
    }
    /*
    DP
     */
//    public int maxSubArray(int[] nums){
//        int[] f = new int[nums.length];
//        f[0] = nums[0];
//        int maxSum = Integer.MIN_VALUE;
//        for (int i = 1; i < nums.length; i++){
//            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
//            maxSum = Math.max(f[i], maxSum);
//        }
//        return maxSum;
//    }


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
