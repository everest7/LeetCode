package DivideAndConquer;

import java.util.Stack;

/**
 * @author Vincent
 * @Date 2019-05-23
 */
public class LargestRectangleinHistogram84 {
    public static void main(String[] args) {
        LargestRectangleinHistogram84 lr = new LargestRectangleinHistogram84();
        System.out.println(lr.largestRectangleArea(new int[] {5,4,1,3,3,4}));
//        System.out.println(lr.largestRectangleArea(new int[] {1, 1}));
    }

    /**
     * Monotonic Stack
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, i = 0;
        while (i <= heights.length) {
            int h = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                // If the stack is empty, meaning all heights being popped were greater than height[t], since height[i]
                // is the lowest bar, we can get the area by height[t] * i.
                if (stack.isEmpty()) {
                    res = Math.max(res, heights[t] * i);
                } else {
                    // If the stack is not empty, meaning there are still bars in stack, the width of rect is (i - stack.peek() - 1)
                    // height 5 6 2
                    // index  2 3 4
                    // Now i = 4, we popped 3 from the stack, and we want to calculate the area of bar 6, the width is 4 - 2 - 1 = 1;
                    res = Math.max(res, heights[t] * (i - stack.peek() - 1));
                }
            }
        }
        return res;
    }

//    public int largestRectangleArea(int[] heights) {
//        if (heights == null || heights.length == 0) return 0;
//        return maxRec(heights, 0, heights.length - 1);
//    }
//    public int maxRec(int[] height, int begin, int end) {
//        if (begin >= end) return height[begin];
//        int minIdx = findMin(height, begin, end);
//        int left = maxRec(height, begin, minIdx - 1);
//        int right = maxRec(height, minIdx + 1, end);
//        return Math.max(minIdx * (end - begin + 1), Math.max(left, right));
//    }
//    public int findMin(int[] height, int begin, int end) {
//        int idx = begin, num = height[begin];
//        for (int i = begin; i <= end; i++) {
//            if (num > height[i]) {
//                num = height[i];
//                idx = i;
//            }
//        }
//        return idx;
//
//    }
}
