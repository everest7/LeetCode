package Hash;

import java.util.*;

/**
 * @Author Vincent
 * @Date 2019-1-14
 * @Review 2019-3-6
 */

public class SubarraySumEqualsK560 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, -1};
        SubarraySumEqualsK560 ss = new SubarraySumEqualsK560();
//        System.out.println(ss.subarraySum(nums, 2));
        List<int[]> res = ss.subarraySumInterval(nums, 2);
        for (int[] inc : res) {
            System.out.println(Arrays.toString(inc));
        }
//        System.out.println(ss.subarraySum(new int[] {1}, 0));
    }

    /**
     * Follow up: print out the interval of subarray
     */
    public List<int[]> subarraySumInterval(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> index = new HashMap<>();
        map.put(0, 1);
        index.put(0, -1);
        List<int[]> intervals = new ArrayList<>();
        int res = 0, sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (map.containsKey(sum - k)){
                res += map.get(sum - k);
                intervals.add(new int[] {index.get(sum - k) + 1, i});
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            index.put(sum, i);
        }
        return intervals;
    }

//    public int subarraySum(int[] nums, int k) {
//        if (nums.length == 0 || nums == null) return 0;
//        int res = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, -1);
//        map.put(nums[0], 0);
//        for (int i = 1; i < nums.length; i++) {
//            nums[i] += nums[i - 1];
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i] - k)) {
//                res++;
//            }
//        }
//        return res;
//    }

    /**
     * Using HashMap
     * Use sum to track the cumulative sum in the array. Storing <sum, freq of sum> in the map
     * when sum[i] - sum[j] == k, (j < i), update the result plus with the freq of sum[j]
     */
    public int subarraySum(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0, sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    /**
     * Brute force
     */
//    public int subarraySum(int[] nums, int k) {
//        int res = 0;
//        for (int i = 0; i < nums.length; i++){
//            int sum = 0;
//            for (int j = i; j < nums.length; j++){
//                sum += nums[j];
//                if (sum == k){
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
}
