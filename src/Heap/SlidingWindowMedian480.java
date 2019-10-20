package Heap;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-07-31
 */
public class SlidingWindowMedian480 {
    public static void main(String[] args) {
        SlidingWindowMedian480 dw = new SlidingWindowMedian480();
        System.out.println(Arrays.toString(dw.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
    }
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        left = new PriorityQueue<Integer>(Collections.reverseOrder());
        right = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (left.size() <= right.size()) {
                right.add(nums[i]);
                left.add(right.remove());
            } else {
                left.add(nums[i]);
                right.add(left.remove());
            }

            if (left.size() + right.size() == k) {
                double median;
                if (left.size() == right.size()) {
                    median = (double) ((long) left.peek() + (long) right.peek()) / 2.0;
                } else {
                    median = (double) left.peek();
                }
                int start = i - k + 1;
                res[start] = median;
                if (!left.remove(nums[start])) {
                    right.remove(nums[start]);
                }
            }
        }
        return res;
    }
}
