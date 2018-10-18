package Sorting;

import java.util.Arrays;

public class WiggleSort28 {
    public static void main(String[] args) {
        int[] nums = {3,2,10,8};
        int[] nums2 = {1,2,3};
        WiggleSort28 ws = new WiggleSort28();
        ws.wiggleSort(nums);
//        ws.wiggleSort(nums2);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
    }

    // Swap integer when:
    // Even index and num[i] greater than num[i+1]
    // Odd index and num[i] less than num[i+1]
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }


    // Sorting the array, and then change order
//    public void wiggleSort(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length - 1; i = i + 2){
//            int temp = nums[i];
//            nums[i] = nums[i + 1];
//            nums[i + 1] = temp;
//        }
//    }
//    public void wiggleSort(int[] nums){
//        boolean less = true;
//        for (int i = 0; i < nums.length - 1; i++){
//            if (less){
//                if (nums[i] > nums[i + 1]){
//                    int temp = nums[i];
//                    nums[i] = nums[i + 1];
//                    nums[i + 1] = temp;
//                }
//            } else {
//                if (nums[i] < nums[i + 1]){
//                    int temp = nums[i];
//                    nums[i] = nums[i + 1];
//                    nums[i + 1] = temp;
//                }
//            }
//            less = !less;
//        }
//    }

}
