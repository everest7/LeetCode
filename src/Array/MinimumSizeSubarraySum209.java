package Array;

public class MinimumSizeSubarraySum209 {
    public static void main(String[] args) {
        MinimumSizeSubarraySum209 ms = new MinimumSizeSubarraySum209();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(ms.minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(sums, sums[i] + s, i + 1, nums.length);
            if (end == sums.length) break;
            res = Math.min(res, end - i);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int binarySearch(int[] A, int key, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    /**
     * Using Binary Search
     */
//    public int minSubArrayLen(int s, int[] nums){
//        int res = Integer.MAX_VALUE;
//        int[] sums = new int[nums.length + 1];
//        for (int i = 1; i < sums.length; i++){
//            sums[i] = sums[i - 1] + nums[i - 1];
//        }
//        for (int i = 0; i < sums.length; i++){
//            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
//            if (end == sums.length) break;
//            res = Math.min(res, end - i);
//        }
//        return res == Integer.MAX_VALUE ? 0 : res;
//    }
//    public int binarySearch(int lo, int hi, int key, int[] nums){
//        while (lo <= hi){
//            int mid = (lo + hi) / 2;
//            if (key <= nums[mid]){
//                hi = mid - 1;
//            } else {
//                lo = mid + 1;
//            }
//        }
//        return lo;
//    }

    /**
     * TWO POINTER
     * @param s
     * @param nums
     * @return
     */
//    public int minSubArrayLen(int s, int[] nums){
//        int res = Integer.MAX_VALUE, left = 0, sum = 0;
//        for (int i = 0; i < nums.length; i++){
//            sum += nums[i];
//            while (left <= i && sum >= s){
//                res = Math.min(res, i - left + 1);
//                sum -= nums[left];
//                left++;
//            }
//        }
//        return res == Integer.MAX_VALUE ? 0 : res;
//    }
//    public int minSubArrayLen(int s, int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int res = Integer.MAX_VALUE;
//        int left = 0, right = 0, sum = 0, len = nums.length;
//        while (right < len){
//            while (sum < s && right < len){
//                sum += nums[right];
//                right++;
//            }
//            while (sum >= s){
//                res = Math.min(res, right - left);
//                sum -= nums[left];
//                left++;
//            }
//        }
//        return res == Integer.MAX_VALUE ? 0: res;
//    }
}
