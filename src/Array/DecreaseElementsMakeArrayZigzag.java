package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent
 * @Date 2019-08-03
 */
public class DecreaseElementsMakeArrayZigzag {
    public static void main(String[] args) {
        DecreaseElementsMakeArrayZigzag de = new DecreaseElementsMakeArrayZigzag();
//        System.out.println(de.movesToMakeZigzag(new int[]{9,6,1,6,2}));
//        System.out.println(de.movesToMakeZigzag(new int[]{1,2,3}));
//        System.out.println(de.movesToMakeZigzag(new int[]{2,1,2}));
        System.out.println(de.movesToMakeZigzag(new int[]{151,42,769,349,835,92,242,82,357,494,880,683,470,631,479,298,941,113,892,103,755,575,885,50,479,502,181,164,292,832,657,512,528,588,716,965,195,106,396,649}));
    }
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(odd(Arrays.copyOfRange(nums, 0, nums.length)), even(Arrays.copyOfRange(nums, 0, nums.length)));
    }

    public int odd(int[] nums) {
        int count = 0;
        for (int i = 0; i <= nums.length - 1; i += 2) {
            if (i == 0) {
                while (nums[i] >= (nums[i + 1])) {
                    nums[i]--;
                    count++;
                }
            } else if (i == nums.length - 1) {
                while (nums[i] >= (nums[i - 1])) {
                    nums[i]--;
                    count++;
                }
            } else {
                while (nums[i] >= Math.min(nums[i - 1], nums[i + 1])) {
                    nums[i]--;
                    count++;
                }
            }

        }
        return count;
    }
    public int even(int[] nums) {
        int count = 0;
        for (int i = 1; i <= nums.length - 1; i += 2) {
            if (i == nums.length - 1) {
                while (nums[i] >= (nums[i - 1])) {
                    nums[i]--;
                    count++;
                }
            } else {
                while (nums[i] >= Math.min(nums[i - 1], nums[i + 1])) {
                    nums[i]--;
                    count++;
                }
            }
        }
        return count;
    }

    Map<Integer, Map<Integer, Integer>> map;
    Map<Integer, Integer> sub;
    int id = 0;
    int len;
//    public SnapshotArray(int length) {
//        this.len = length;
//        map = new HashMap<>();
//        sub = new HashMap<>();
//        map.put(id, sub);
//    }
//
//    public void set(int index, int val) {
//        Map<Integer, Integer> sub = map.get(id);
//        sub.put(index, val);
//    }
//
//    public int snap() {
//        Map<Integer, Integer> copy = new HashMap<>();
//        copy.putAll(map.get(id));
//        id++;
//        map.put(id, copy);
//        return id - 1;
//    }
//
//    public int get(int index, int snap_id) {
//        return map.get(snap_id).get(index);
//    }
}
