package BinarySearch;

import java.util.*;

public class IntersectionOfArray349 {
    public static void main(String[] args) {
        IntersectionOfArray349 is = new IntersectionOfArray349();
        int[] nums1 = {1};
        int[] nums2 = {1};
        System.out.println(Arrays.toString(is.intersection(nums1,nums2)));

    }
    // Time complextity O(n)
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> intersect = new HashSet<>();
//        Set<Integer> set1 = new HashSet<>();
//        for (int i = 0; i < nums1.length; i++){
//            set1.add(nums1[i]);
//        }
//        for (int j = 0; j < nums2.length; j++){
//            if (set1.contains(nums2[j])){
//                intersect.add(nums2[j]);
//            }
//        }
//
//        int[] res = new int[intersect.size()];
//        int i = 0;
//        for (Integer num : intersect){
//            res[i++] = num;
//        }
//        return res;
//    }
    public int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> set1 = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1){
            if (binarySearch(nums2, num)){
                set1.add(num);
            }
        }
        int[] res = new int[set1.size()];
        int i = 0;
        for (Integer num : set1){
            res[i++] = num;
        }
        return res;
    }
    public boolean binarySearch(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
