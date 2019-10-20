package Array;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-07-23
 */
public class MoveZeros283 {
    public static void main(String[] args) {
        MoveZeros283 mz = new MoveZeros283();
        int[] nums = new int[] {0,1,0,3,12};
        mz.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

//    public void moveZeroes(int[] nums) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == 0) {
//                int j = i + 1;
//                while (j < nums.length - 1 && nums[j] == 0) {
//                    j++;
//                }
//                int tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = tmp;
//            }
//        }
//    }

    /**
     * Follow up1: count the number of zeros
     * Ans: left is incremented whenever we met a non-zero element, so left is the number of non-zero element,
     * length - left is number of zeros
     *
     * Follow up2: maintaining the order of original numbers. Since every time we met a non-zero element, we swap
     * it with the first zero in the array, so the order is maintained.
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
