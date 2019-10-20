package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent
 * @Date 2019-06-29
 */
public class ContiguousArray525 {
    public static void main(String[] args) {
        int[] nums = new int[] {0,0,0,1,0,1,0,1};
        ContiguousArray525 ca = new ContiguousArray525();
        System.out.println(ca.findMaxLength(nums));
    }

    /**
     * If we encounter the same sum, meaning there are equal numbers of 0's and 1's.953
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}
