package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        int[] nums2 = {-3,-2,-1,0,0,1,2,3};
        int[] nums3 = {-1,0,-5,-2,-2,-4,0,1,-2};
        FourSum18 fs = new FourSum18();
        System.out.println(fs.fourSum(nums3, -9));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int sum = target - nums[i] - nums[j];
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
                while (j < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i < nums.length - 3 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 3; i++){
////            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            for (int j = i + 1; j < nums.length - 2; j++){
//
//                int sum = target - nums[i] - nums[j];
//                int left = j + 1;
//                int right = nums.length - 1;
//                while (left < right){
//                    if (nums[left] + nums[right] < sum){
//                        left++;
//                    } else if (nums[left] + nums[right] > sum){
//                        right--;
//                    } else {
//                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
//                        while (left < right && nums[left] == nums[left + 1]) left++;
//                        while (left < right && nums[right] == nums[right - 1]) right--;
//                        left ++;
//                        right --;
//                    }
//                }
//                while (j + 2 < nums.length && nums[j] == nums[j + 1]) j++;
//            }
//            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
//        }
//        return res;
//    }
}
