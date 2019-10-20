package Array;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-06-04
 */
public class ContiguousArray525 {
    public static void main(String[] args) {
        ContiguousArray525 ca = new ContiguousArray525();
        System.out.println(ca.findMaxLength(new int[] {0,1,1,0,1,0}));
    }
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                res = Math.max(res, i + 1 - map.get(sum));
            } else {
                map.put(sum, i + 1);
            }
        }
        return res;
    }

//    public int findMaxLength(int[] nums) {
//        int count = 0, res = 0;
//        int[] arr = new int[nums.length * 2 + 1];
//        Arrays.fill(arr, -2);
//        arr[nums.length] = -1;
//        for (int i = 0; i < nums.length; i++) {
//            count += nums[i] == 1 ? 1 : -1;
//            if (arr[count + nums.length] >= -1) {
//                res = Math.max(res, i - arr[count + nums.length]);
//            } else {
//                arr[count + nums.length] = i;
//            }
//        }
//        return res;
//    }
}
