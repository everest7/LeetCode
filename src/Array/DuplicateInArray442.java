package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateInArray442 {
    public static void main(String[] args) {
        DuplicateInArray442 da = new DuplicateInArray442();
        int[] nums1 = {4,3,2,7,8,2,3,1};
        System.out.println(da.findDuplicates(nums1));

    }
//    public List<Integer> findDuplicates(int[] nums){
//        List<Integer> res = new ArrayList<Integer>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 1; i++){
//            if (nums[i] == nums[i+1]){
//                res.add(nums[i]);
//            }
//        }
//        return res;
//    }

    //O(n) in time complexity and O(1) in space complexity
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
}

}
