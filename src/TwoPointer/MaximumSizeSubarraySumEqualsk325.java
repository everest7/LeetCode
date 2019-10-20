package TwoPointer;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-15
 */
public class MaximumSizeSubarraySumEqualsk325 {
    public static void main(String[] args) {
        System.out.println(maxSubArrayLen(new int[] {1, -1, 5, -2, 3}, 3));
        System.out.println(maxSubArrayLen(new int[] {-2, -1, 2, 1}, 1));
    }

    public static int maxSubArrayLen(int[] nums, int k) {
        int left = 0, len = 0;
        int[] sum = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            if (!map.containsKey(sum[i])) map.put(sum[i], i);
        }
        for (int i = 1; i < sum.length; i++) {
            if (map.containsKey(sum[i] - k)) {
                len = Math.max(len, i - map.get(sum[i] - k));
            }
        }
        return len;
    }
}
