package Stack;

import java.util.*;

public class NextGreaterNum496 {
    public static void main(String[] args) {
        NextGreaterNum496 ngn = new NextGreaterNum496();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] nums11= {1,3,5,2,4};
        int[] nums22= {6,5,4,3,2,1,7};
        System.out.println(Arrays.toString(ngn.nextGreaterElement(nums1, nums2)));

    }
    // Using stack to store the numbers that are smaller than 'num', put those number with 'num' into
    // map as <K,V> pair.
    // Retrieve the pair from map, if the V does not exist, fill in with -1, which means there is no greater number
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums2){
            while (!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
    // Brute force Sovling
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums1.length ; i++){
//            for (int j = 0; j < nums2.length ; j++){
//                if (nums1[i] == nums2[j]){
//                    for (int k = j + 1; k < nums2.length; k++){
//                        if (nums2[k] > nums2[j]){
//                            list.add(nums2[k]); break;
//                        } else {
//                            list.add(-1);
//                        }
//                    }
//                    if (j == nums2.length - 1) list.add(-1);
//                }
//            }
//        }
//        int[] res = new int[list.size()];
//        int count = 0;
//        for (int num: list){
//            res[count++] = num;
//        }
//        return res;
//    }
}
