package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Vincent
 * @Date 2019-07-09
 */
public class NextGreaterElementII503 {
    public static void main(String[] args) {
        NextGreaterElementII503 ng = new NextGreaterElementII503();
        System.out.println(Arrays.toString(ng.nextGreaterElements(new int[] {1, 2, 1})));
    }

    /**
     * Monotonous Stack
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % nums.length] >= nums[stack.peek()]) {
                stack.pop();
            }
            res[i % nums.length] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

//    public int[] nextGreaterElements(int[] nums) {
//        int[] res = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            res[i] = -1;
//            for (int j = 1; j < nums.length; j++) {
//                if (nums[(i + j) % nums.length] > nums[i]) {
//                    res[i] = nums[(i + j) % nums.length];
//                    break;
//                }
//            }
//        }
//        return res;
//    }
}
