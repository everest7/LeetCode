package Array;

import java.util.Arrays;

public class NextPermutation31 {
    public static void main(String[] args) {
        NextPermutation31 np = new NextPermutation31();
        int[] nums = {1, 2, 3};
        int[] nums2 = {2,3,2,1};
//        np.nextPermutation(nums);
//        System.out.println(Arrays.toString(nums));
//        np.nextPermutation(nums2);
        np.prevPermutation(nums2);
        System.out.println(Arrays.toString(nums2));
    }
    public void nextPermutation(int[] nums) {
        int firstSmall = -1;
        int len = nums.length - 1;
        for (int i = len; i > 0; i--){
            if (nums[i] > nums[i - 1]){
                firstSmall = i - 1;
                break;
            }
        }
        if (firstSmall == -1){
            reveres(nums, 0, len);
            return;
        }
        int firstLarge = -1;
        for (int i = len; i >= 0; i--){
            if (nums[i] > nums[firstSmall]){
                firstLarge = i;
                break;
            }
        }
        swap(nums, firstLarge, firstSmall);
        reveres(nums, firstSmall + 1, len);
        return;
    }

    public void reveres(int[] nums, int i, int j){
        while (i < j){
            swap(nums, i++, j--);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Follow up: Previous permutation
     * find first i such that A[i-1] > A[i], firstLarge = i - 1;
     * Similar approach to nextPermutation
     */

    public void prevPermutation(int[] nums) {
        int firstSmall = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i - 1] > nums[i]) {
                firstSmall = i - 1;
                break;
            }
        }
        if (firstSmall == -1) {
            reveres(nums, 0, nums.length - 1);
            return;
        }
        int smallest = nums[nums.length - 1], smallIdx = nums.length - 1;
        for (int i = nums.length - 1; i >= firstSmall + 1; i--) {
            if (nums[i] < smallest) {
                smallest = nums[i];
                smallIdx = i;
                break;
            }
        }
        swap(nums, firstSmall, smallIdx);
        reveres(nums, firstSmall + 1, nums.length - 1);

    }
}
