package Array;

import java.util.Arrays;

public class ThreeSum259 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        ThreeSum259 ts = new ThreeSum259();
        System.out.println(ts.threeSumSmaller(nums, 2));
    }



    // Using Two Pointer
    // The outer loop iterates through the array, the inner loop starts from low = i + 1,
    // When i, low, high satisfy the condition, all indexes between [low, high] will satisfy the condition.
    // Time Complexity O(n^2), Space complexity O(1)
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++){
            int low = i + 1, high = nums.length - 1;
            while (low < high){
                if (nums[i] + nums[low] + nums[high] < target) {
                    count += high - low;
                    low++;
                } else {
                    high--;
                }
            }

        }
        return count;
    }

    // Using Binary Search
//    public int threeSumSmaller(int[] nums, int target){
//        int count = 0;
//
//    }
}
