package Hash;
import java.util.*;
/**
 * @author Vincent
 * @Date 9/15/19
 */
public class SlidingWindowMedian {
    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        System.out.println(Arrays.toString(medianSlidingWindow(nums, 3)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[] {1,4,2,3}, 4)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n - k + 1];
        Comparator<Integer> comp = (a, b) -> nums[a] == nums[b] ? a - b : Integer.compare(nums[a], nums[b]);
        TreeSet<Integer> left = new TreeSet<>(comp);
        TreeSet<Integer> right = new TreeSet<>(comp);
        for (int i = 0; i < n; i++) {
            if (left.size() <= right.size()) {
                right.add(i);
                int rem = right.first();
                right.remove(rem);
                left.add(rem);
            } else {
                left.add(i);
                int rem = left.last();
                left.remove(rem);
                right.add(rem);
            }

            if (left.size() + right.size() == k) {
                double val;
                if (left.size() == right.size()) {
                    val = (nums[left.last()] + nums[right.first()]) / 2.0;
                } else if (left.size() < right.size()) {
                    val = (double) nums[right.first()];
                } else {
                    val = (double) nums[left.last()];
                }
                res[i + 1 - k] = val;
                if (!left.remove(i + 1 - k)) {
                    right.remove(i + 1 - k);
                }
            }
        }
        return res;
    }
}
