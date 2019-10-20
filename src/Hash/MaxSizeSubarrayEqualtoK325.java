package Hash;

import java.util.HashMap;

/**
 * @author Vincent
 * @Date 2019-05-30
 */
public class MaxSizeSubarrayEqualtoK325 {
    public static void main(String[] args) {
        MaxSizeSubarrayEqualtoK325 ms = new MaxSizeSubarrayEqualtoK325();
        System.out.println(ms.maxSubArrayLen(new int[] {-5,8,2,-1,6,-3,7,1,8,-2,7}, -4));
    }

    public int maxSubArrayLen(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < sum.length; i++) {
            map.put(sum[i], i);
        }

        for (int i = 0; i < sum.length; i++) {
            if (map.containsKey(sum[i] + k)) {
                if (res < map.get(sum[i] + k) - i + 1) {
                    res = map.get(sum[i] + k) - i + 1;
                }
            }
        }
        return res;
    }
}
