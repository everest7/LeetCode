package Heap;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-16
 */
public class FindKthSmallestPairDistance719 {
    public static void main(String[] args) {
        System.out.println(smallestDistancePair(new int[] {1,3,4,6}, 1));
    }

    /**
     * Binary search
     * cnt += (j - i - 1) minus here because j starts from same position as i, but (i, i) cannot form a pair
     * @param nums
     * @param k
     * @return
     */
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0], len = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2, cnt = 0;
            for (int i = 0, j = 0; i < len; i++) {
                while (j < len && nums[i] + mid >= nums[j]) {
                    j++;
                }
                cnt += (j - i - 1); // count how many such pair,
            }
            if (cnt < k) { // setting range is smaller
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left;


//        Arrays.sort(nums);
//        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
//        while (left < right) {
//            int mid = left + (right - left) / 2, cnt = 0;
//            for (int i = 0, j = 0; i < n; i++) {
//                while (j < n && nums[j] <= nums[i] + mid) {
//                    j++;
//                }
//                cnt += (j - i - 1);
//            }
//            if (cnt < k) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return left;
    }

//    public static int smallestDistancePair(int[] nums, int k) {
//        int[] dist = new int[1000001];
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int dis = Math.abs(nums[i] - nums[j]);
//                dist[dis]++;
//            }
//        }
//        int idx = 0, i = 0, res = 0;
//        while (idx < k && i < 1000001) {
//            idx += dist[i];
//            if (idx >= k) {
//                res = i;
//                break;
//            }
//            i++;
//        }
//        return res;
//    }

//    public static int smallestDistancePair(int[] nums, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                pq.add(Math.abs(nums[i] - nums[j]));
//            }
//        }
//        int i = 0;
//        while (i < k - 1) {
//            pq.poll();
//            i++;
//        }
//        return pq.poll();
//    }
}
