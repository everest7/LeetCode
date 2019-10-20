package Hash;

import java.util.ArrayDeque;
import java.util.*;
import java.util.Deque;

public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        SlidingWindowMaximum239 sw = new SlidingWindowMaximum239();
        System.out.println(Arrays.toString(sw.maxSlidingWindow(nums, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        for (int i = 0; i < nums.length; i++) {
            while (!pq.isEmpty() && pq.peek()[1] <= i - k) pq.poll();
            pq.add(new int[]{nums[i], i});
            if (i >= k - 1) res[idx++] = pq.peek()[0];
        }
        return res;
    }
    /*
    Monotonic Queue
     */
//    public int[] maxSlidingWindow(int[] nums, int k){
//        if (nums.length == 0 || nums.length < k) return new int[0];
//        int len = nums.length;
//        int res[] = new int[len - k + 1];
//        int index = 0;
//        Deque<Integer> deque = new ArrayDeque<>();
//        for (int i = 0; i < len; i++){
//            // When the window size exceeds k
//            while (!deque.isEmpty() && deque.peek() < i - k + 1){
//                deque.poll();
//            }
//            // remove smaller number as they will not be the max number
//            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
//                deque.pollLast();
//            }
//            deque.offer(i);
//            // Reached k element in the array, useful in first encounter
//            if (i >= k - 1){
//                res[index++] = nums[deque.peek()];
//            }
//        }
//        return res;
//    }

    /*
    Brute force
     */
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums == null || nums.length < k) return new int[0];
//        int len = nums.length;
//        int[] res = new int[len - k + 1];
//        int index = 0;
//        for (int i = 0; i < len - k + 1; i++){
//            int temp = Integer.MIN_VALUE;
//            for (int j = i; j < i + k; j++){
//                temp = Math.max(temp, nums[j]);
//            }
//            res[index++] = temp;
//        }
//        return res;
//    }
}
