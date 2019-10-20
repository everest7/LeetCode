package BinarySearch;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 9/19/19
 */
public class KSmallestPair {
    public static void main(String[] args) {
//        System.out.println(smallestDistancePair(new int[]{1,6,1}, 3));
        System.out.println(smallestDistancePair(new int[]{1,3,1}, 1));
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2, cnt = 0;
            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && nums[i] + mid >= nums[j]) {
                    j++;
                }
                cnt += (j - i - 1);
            }
            if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
