package BinarySearch;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-05-10
 */
public class FirstAndLastPostionOfEleInSorted34 {
    public static void main(String[] args) {
        FirstAndLastPostionOfEleInSorted34 fs = new FirstAndLastPostionOfEleInSorted34();
        System.out.println(Arrays.toString(fs.searchRange(new int[] {5,7,7,8,8,10}, 8)));
    }

    /**
     * Note this version !!!
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        int first = -1, last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) { // if found the target, mark its index and then go to left interval
                first = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (first == -1) return new int[]{-1, -1};
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) { // if found the target, mark its index and then go to right interval
                last = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{first, last};
    }

//    public int[] searchRange(int[] nums, int target) {
//        int[] res = new int[] {-1, -1};
//        if (nums == null || nums.length == 0) return res;
//        int left = 0, right = nums.length - 1;
//        int index1 = 0, index2 = 0;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                index1 = mid;
//            }
//            if (nums[mid] >= target){
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//
//        }
//        if (nums[index1] != target) {
//            return res;
//        }
//        res[0] = index1;
//        right = nums.length - 1;
//        while (left <= right ) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] <= target){
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//            if (nums[mid] == target) {
//                index2 = mid;
//            }
//        }
//        res[1] = index2;
//        return res;
//    }

//    public int[] searchRange(int[] nums, int target) {
//        if (nums.length == 1 && nums[0] == target) return new int[] {0, 0};
//        int[] res = new int[2];
//        Arrays.fill(res, -1);
//        int left = 0, right = nums.length - 1;
////        while (left < right) {
////            int mid = left + (right - left) / 2;
////            if (nums[mid] < target) {
////                left = mid + 1;
////            } else {
////                right = mid;
////            }
////        }
//        int index = -1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                index = mid;
//                right = mid - 1;
//            } else if (nums[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        if (nums[index] != target) {
//            return res;
//        }
//        res[0] = index;
////        if (nums[right] != target) {
////            return res;
////        }
////        res[0] = right;
//        right = nums.length;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] <= target) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        res[1] = left - 1;
//        return res;
//    }
}
