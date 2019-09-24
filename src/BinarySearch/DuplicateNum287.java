package BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class DuplicateNum287 {
    public static void main(String[] args) {
        DuplicateNum287 dn = new DuplicateNum287();
        int[] nums = {1,3,4,2,2};
        System.out.println(dn.findDuplicate(nums));
    }

    // Using Binary Search
    // Count the amount of numbers that is less than or equal to mid, if the count is less than mid, that means
    // the duplicate number lies in [mid+1,n]. Otherwise, the duplicate number lies in [0, mid-1]
    public int findDuplicate(int[] nums){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int count = 0;
            int mid = left + (right - left) / 2;
            for (int num : nums){
                if (num <= mid) count++;
            }
            if (count <= mid) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    // Using HashMap Space: O(n)
//    public int findDuplicate(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int num : nums){
//            map.put(num,map.getOrDefault(num,0) + 1);
//            if (map.get(num) > 1){
//                return num;
//            }
//        }
//        return 0;
//    }
}
