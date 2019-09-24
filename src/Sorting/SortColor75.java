package Sorting;

import java.util.Arrays;

public class SortColor75 {
    public static void main(String[] args) {
        int[] nums = {0,0,2,1,1,0};
        int[] nums2 = {1,2,0};
        SortColor75 sc = new SortColor75();
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

//    public void sortColors(int[] nums){
//        int left = 0, right = nums.length - 1;
//        int index = 0;
//        while (index <= right){
//            if (nums[index] == 0){
//                swap(nums, index++, left++);
//            } else if (nums[index] == 1){
//                index++;
//            }else {
//                swap(nums, index++, right--);
//            }
//        }
//    }
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
            }
            else if (nums[i] == 2) {
                swap(nums, right--, i--);
                // right--;
                // i--;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
//    public void sortColors(int[] nums) {
//        int[] output = new int[nums.length];
//        int[] count = new int[3];
//        for (int num : nums){
//            count[num]++;
//        }
//        for (int i = 0; i < count.length - 1; i++){
//            count[i+1] += count[i];
//        }
//        for (int i = 0; i < output.length ; i++){
//            output[count[nums[i]] - 1] = nums[i];
//            count[nums[i]]--;
//        }
//        for (int i = 0; i < output.length; i++){
//            nums[i] = output[i];
//        }
//
//    }
}
