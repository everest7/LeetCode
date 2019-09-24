package Array;

/**
 * @Review 2019-3-9
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumofThree15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {1,-1,-1,0};
        SumofThree15 st = new SumofThree15();
        System.out.println(st.threeSum(nums2));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                if (nums[left] + nums[right] < -nums[i]) {
                    right--;
                } else if (nums[left] + nums[right] > -nums[i]) {
                    left++;
                } else {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[left]);
                    sub.add(nums[right]);
                    left++;
                    right--;
                    res.add(sub);
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return res;
    }
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++){
//            if (i == 0 || (i > 0 && nums[i] != nums[i-1])){
//                int low = i + 1;
//                int high = nums.length - 1;
//                while (low < high){
//                    if (nums[i] + nums[low] + nums[high] == 0){
//                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
//                        while (low < high && nums[low] == nums[low + 1]) low++;
//                        while (low < high && nums[high] == nums[high - 1]) high--;
//                        low++;
//                        high--;
//                    } else if (nums[i] + nums[low] + nums[high] < 0){
//                        low++;
//                    } else {
//                        high--;
//                    }
//                }
//
//            }
//        }
//        return res;
//    }
}
