package DynamicProgramming;

import java.util.Stack;

/**
 * July 10
 */
public class TrappingRainWater42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater42 tr = new TrappingRainWater42();
        System.out.println(tr.trap(height));
    }

    /**
     * Monotonic Stack
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, res = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int lowest = stack.pop();
                if (stack.isEmpty()) continue;
                res += (Math.min(height[i], height[stack.peek()]) - height[lowest]) * (i - stack.peek() - 1);
            }
        }
        return res;
    }


    /**
     * Two pointer
     * Use two pointer to keep track of left_max and right_max simultaneously
     * instead of using two array keeping track of left_max and right_max respectively
     */
//    public int trap(int[] height) {
//        int left = 0;
//        int right = height.length - 1;
//        int leftMax = 0;
//        int rightMax = 0;
//        int res = 0;
//        while (left < right){
//            if (height[left] < height[right]){
//                leftMax = Math.max(leftMax, height[left]);
//                res += leftMax - height[left];
//                left++;
//            } else {
//                rightMax = Math.max(rightMax, height[right]);
//                res += rightMax - height[right];
//                right--;
//            }
//        }
//        return res;
//    }

    /**
     * Dynamic Programming
     */
//    public int trap(int[] height){
//        int[] left_max = new int[height.length];
//        int[] right_max = new int[height.length];
//        left_max[0] = height[0];
//        for (int i = 1; i < height.length; i++){
//            left_max[i] = Math.max(left_max[i - 1], height[i]);
//        }
//        right_max[height.length - 1] = height[height.length - 1];
//        for (int j = height.length - 2; j >= 0; j--){
//            right_max[j] = Math.max(right_max[j + 1], height[j]);
//        }
//        int res = 0;
//        for (int i = 0; i < height.length; i++){
//            res += Math.min(left_max[i], right_max[i]) - height[i];
//        }
//        return res;
//    }


    /**
     * Brute force
     */
//    public int trap(int[] height) {
//        int res = 0;
//        int size = height.length;
//        for (int i = 1; i < size - 1; i++){
//            int max_left = 0, max_right = 0;
//            for (int j = i; j >= 0 ; j--){
//                max_left = Math.max(max_left, height[j]);
//            }
//            for (int j = i; j < size; j++){
//                max_right = Math.max(max_right, height[j]);
//            }
//            res += Math.min(max_left, max_right) - height[i];
//        }
//        return res;
//    }
}
