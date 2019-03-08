package Array;

import java.util.Arrays;

public class SumofThreeClosest16 {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        SumofThreeClosest16 st = new SumofThreeClosest16();
        System.out.println(st.threeSumClosest(nums, 1));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++){
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if (sum < target){
                    low++;
                } else {
                    high--;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }

            }
        }
        return res;
    }
}
