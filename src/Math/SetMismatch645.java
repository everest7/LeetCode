package Math;

import java.util.Arrays;

public class SetMismatch645 {
    public static void main(String[] args) {
        SetMismatch645 sm = new SetMismatch645();
        int[] nums1 = {1,2,2,4};
        int[] nums2 = {1,1};
        System.out.println(Arrays.toString(sm.findErrorNums(nums1)));
    }
//    public int[] findErrorNums(int[] nums) {
//        int[] res = new int[2];
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 1; i++){
//            if (nums[i] == nums[i+1]){
//                res[0] = nums[i];
//            }
//            if (nums[i+1] - nums[i] == 2){
//                res[1] = i+1;
//            }
//            if (nums[nums.length - 2] ==nums[nums.length -1]){
//                res[1] = nums.length;
//            }
//
//        }
//        return res;
//    }
//    public int[] findErrorNums(int[] nums) {
//        int n = nums.length;
//        int[] count = new int[n];
//        int[] ans = {0,0};
//        for(int i = 0; i < n; i++) {
//            ans[1] ^= (i+1) ^ nums[i];
//            if (++count[nums[i]-1] == 2)
//                ans[0] = nums[i];
//        }
//        ans[1] ^= ans[0];
//        return ans;
//    }
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] count = new int[nums.length];
        for (int num : nums){
            ++count[num - 1];
        }
        for (int j = 0; j < count.length; j++){
            if(res[0] != 0 && res[1] != 0) return res;
            if (count[j] == 2){
                res[0] = j + 1;
            }
            if(count[j] == 0){
                res[1] = j + 1;
            }
        }
        return res;
    }
}
