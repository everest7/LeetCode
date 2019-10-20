package Tree;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-04-02
 */
public class ContainDupliacteIII220 {
    public static void main(String[] args) {
        ContainDupliacteIII220 cd = new ContainDupliacteIII220();
        System.out.println(cd.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
    }

    /**
     * TreeSet
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> bst = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // Find first smaller element <= num
            Integer ceil = bst.ceiling(nums[i]);
            if (ceil != null && Long.valueOf(ceil) - Long.valueOf(nums[i]) <= t) {
                return true;
            }
            // Find the first element >= num
            Integer floor = bst.floor(nums[i]);
            if (floor != null && Long.valueOf(nums[i]) - Long.valueOf(floor) <= t) {
                return true;
            }
            bst.add(nums[i]);
            if (bst.size() > k) {
                bst.remove(nums[i - k]);
            }
        }
        return false;
    }

    /**
     * TLE
     * @return
     */
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
//                if (Math.abs(Long.valueOf(nums[j]) - Long.valueOf(nums[i])) <= t) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
