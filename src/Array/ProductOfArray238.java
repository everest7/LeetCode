package Array;

import java.util.Arrays;

public class ProductOfArray238 {
    public static void main(String[] args) {
        ProductOfArray238 pa = new ProductOfArray238();
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {3,2,2,1};
        System.out.println(Arrays.toString(pa.productExceptSelf(nums1)));
        System.out.println(Arrays.toString(pa.productExceptSelf(nums2)));
        System.out.println(Arrays.toString(pa.productExceptSelf2(nums2)));
    }

//    public int[] productExceptSelf(int[] nums) {
//        int[] res = new int[nums.length];
//        int sum = 1;
//        for (int i = 0; i < nums.length; i++){
//            sum *= nums[i];
//        }
//        for (int i = 0; i < nums.length; i++){
//            res[i] = sum / nums[i];
//        }
//        return res;
//    }
//    public int[] productExceptSelf(int[] nums) {
//        int leng = nums.length;
//        int[] ret = new int[leng];
//        if(leng == 0)
//            return ret;
//        int runningprefix = 1;
//        for(int i = 0; i < leng; i++){
//            ret[i] = runningprefix;
//            runningprefix*= nums[i];
//        }
//        int runningsufix = 1;
//        for(int i = leng -1; i >= 0; i--){
//            ret[i] *= runningsufix;
//            runningsufix *= nums[i];
//        }
//        return ret;
//    }

    public int [] productExceptSelf(int[] nums){
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++){
            res[i] = res[i-1] * nums[i-1];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;

    }

    /**
     * Follow up: Division is allowed.
     */

    public int[] productExceptSelf2(int[] nums) {
        int sum = 1, count = 0;
        for (int num: nums) {
            if (num == 0) count++;
            else {
                sum *= num;
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i] == 0 ? (count > 1 ? 0 : sum) : (count > 0 ? 0 : sum / nums[i]);
        }
        return res;
    }


}
