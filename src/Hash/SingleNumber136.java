package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber136 {
    public static void main(String[] args) {
        SingleNumber136 sn = new SingleNumber136();
        int[] nums = {4,1,2,1,2};
        System.out.println(sn.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            res ^= nums[i];

        }
        return res;
    }
    // Using HashMap
//    public int singleNumber(int[] nums) {
//        Map<Integer,Integer> res = new HashMap<>();
//        for (int i = 0; i < nums.length; i ++){
//            res.put(nums[i],res.getOrDefault(nums[i],0) + 1);
//        }
//        int result = 0;
//        for (Map.Entry<Integer,Integer> entry : res.entrySet()){
//            if (entry.getValue() == 1){
//                result = entry.getKey();
//            }
//        }
//        return result;
//    }

}
