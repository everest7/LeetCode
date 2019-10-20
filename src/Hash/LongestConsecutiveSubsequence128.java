package Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vincent
 * @Date 2019-07-02
 */
public class LongestConsecutiveSubsequence128 {
    public static void main(String[] args) {
        LongestConsecutiveSubsequence128 lc = new LongestConsecutiveSubsequence128();
        System.out.println(lc.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    }

    /**
     * In the first pass, we use a HashSet to store the numbers.
     * In the second pass, we check if the neighbors (pre = num - 1, next = num + 1) exist in the set.
     * As we checking for neighbors, we maintain the maximum length (next - prev - 1)
     * Why minus one?
     * Because in the end, the next and prev will not exist in the set.
     * next - prev - 1 gives us the length exclude next and prev, which is the subsequence we want.
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                int prev = num - 1, next = num + 1;
                set.remove(num);
                while (set.contains(prev)) {
                    set.remove(prev);
                    prev--;
                }
                while(set.contains(next)) {
                    set.remove(next);
                    next++;
                }
                res = Math.max(res, next - prev - 1);
            }
        }
        return res;
    }

//    public int longestConsecutive(int[] nums) {
//        int res = 0;
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//            int len = 1;
//            int high = nums[i] + 1;
//            while (set.contains(high)) {
//                set.remove(high);
//                high++;
//                len++;
//            }
//            int low = nums[i] - 1;
//            while (set.contains(low)) {
//                set.remove(low);
//                low--;
//                len++;
//            }
//            res = Math.max(res, len);
//
//        }
//        return res;
//    }
}
