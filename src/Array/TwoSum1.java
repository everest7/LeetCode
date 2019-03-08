package Array;

import java.util.*;

public class TwoSum1 {
    public static void main(String[] args) {
        TwoSum1 ts = new TwoSum1();
        int[] nums = {3,4,5,8};
        System.out.println(Arrays.toString(ts.twoSum(nums,11)));
    }
    // Using HashMap to store the <number index> pair.
    // Iterate throught the array, check if the map containsKey(target - nums[i])
    // return i and the other index as result
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                if (map.get(target-nums[i]) != i){
                    res[0] = i;
                    res[1] = map.get(target-nums[i]);
                    break;
                }
            }
        }
        return res;
    }
}
