package Sorting;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-05-16
 */
public class WiggleSort324 {
    public static void main(String[] args) {
        WiggleSort324 ws = new WiggleSort324();
        int[] nums = new int[] {1, 5, 1, 1, 6, 4};
        ws.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 1) return;

        int[] copy = new int[nums.length];
        copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int len = copy.length;
        int j = (len + 1) / 2, k = len;;
        for (int i = 0; i < len; i++) {
            nums[i] = i % 2 == 0 ? copy[--j] : copy[--k];
        }

    }
}
