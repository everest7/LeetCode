package Array;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-06-15
 */
public class DuplicateZeros1089 {
    public static void main(String[] args) {
        DuplicateZeros1089 dz = new DuplicateZeros1089();
        int[] num = new int[] {1,0,2,3,0,4,5,0};
        dz.duplicateZeros(num);
        System.out.println(Arrays.toString(num));
    }

    public void duplicateZeros(int[] arr) {
        int[] nums = new int[arr.length * 2];
        int i = 0, j = 0;
        while (i < arr.length && j < nums.length) {
            if (arr[i] != 0) {
                nums[j++] = arr[i++];
            } else {
                nums[j++] = 0;
                nums[j++] = 0;
                i++;
            }
        }
        for (int k = 0; k < arr.length; k++) {
            arr[k] = nums[k];
        }
    }
}
