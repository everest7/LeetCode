package Array;

import java.util.Stack;

/**
 * @author Vincent
 * @Date 2019-07-03
 */
public class ShortestUnsortedContinousArray581 {
    public static void main(String[] args) {
        ShortestUnsortedContinousArray581 ss = new ShortestUnsortedContinousArray581();
        System.out.println(ss.findUnsortedSubarray(new int[] {1,2,3,3,3}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int left = 0, right = nums.length - 1;
        boolean ascending = false, descending = false;
        while (left < right) {
            if (nums[left] > nums[left + 1]) {
                ascending = true;
            } else {
                left++;
            }
            if (nums[right] < nums[right - 1]) {
                descending = true;
            } else {
                right--;
            }
            if (ascending && descending) break;
        }
        return right - left + 1;
    }

//    public int findUnsortedSubarray(int[] nums) {
//        if (nums.length < 2) return 0;
//        Stack<Integer> stack = new Stack<>();
//        int left = nums.length - 1, right = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (stack.isEmpty() || nums[i] >= nums[stack.peek()]) {
//                stack.push(i);
//            } else {
//                left = Math.min(left, stack.pop());
//                i--;
//            }
//        }
//        stack.clear();
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (stack.isEmpty() || nums[i] <= nums[stack.peek()]) {
//                stack.push(i);
//            } else {
//                right = Math.max(right, stack.pop());
//                i++;
//            }
//        }
//        return right - left > 0 ? right - left + 1 : 0;
//    }
}
