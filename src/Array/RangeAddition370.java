package Array;

import java.util.Arrays;

public class RangeAddition370 {
    public static void main(String[] args) {
        RangeAddition370 ra = new RangeAddition370();
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        System.out.println(Arrays.toString(ra.getModifiedArray(5, updates)));
    }

    // Time complexity: O(n+k)
    // Explanation: Increment the element at starting index by +inc,
    // increment the element at ending index plus one by -inc.
    // calculate the cumulative sum from index 1 to index length - 1
    public int[] getModifiedArray(int length, int[][] updates){
        int[] nums = new int[length];
        for (int[] update: updates){
            nums[update[0]] += update[2];
            if (update[1] < length - 1){
                nums[update[1] + 1] -= update[2];
            }
        }

        for (int i = 1; i < length; i++){
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    // Naive approach
//    public int[] getModifiedArray(int length, int[][] updates) {
//        int[] nums = new int[length];
//        for (int[] update: updates){
//            for (int i = update[0]; i <= update[1]; i++){
//                nums[i] += update[2];
//            }
//        }
//        return nums;
//    }
}
