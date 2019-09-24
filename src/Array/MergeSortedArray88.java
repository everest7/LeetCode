package Array;

import java.util.Arrays;

public class MergeSortedArray88 {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
        int[] nums1 = {0};
        int[] nums2 = {1};
//        int[] nums2 = {2,5,6};
        MergeSortedArray88 ms = new MergeSortedArray88();
        ms.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = n - 1, i = m - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }

    }

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int right = m - 1, high = n - 1;
//        int total = m + n - 1;
//        while (right >= 0 && high >= 0){
//            if (nums1[right] > nums2[high]){
//                nums1[total--] = nums1[right--];
//
//            }else {
//                nums1[total--] = nums2[high--];
//            }
//        }
//        while (high >= 0){
//            nums1[total--] = nums2[high--];
//        }
//    }
}
