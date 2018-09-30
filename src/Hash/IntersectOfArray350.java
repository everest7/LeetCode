package Hash;

import java.util.*;

public class IntersectOfArray350 {
    public static void main(String[] args) {
        IntersectOfArray350 is = new IntersectOfArray350();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(is.intersect(nums1,nums2)));
    }
    public int[] intersect(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i], 1);
        }

        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
        {
            res[i] = result.get(i);
        }

        return res;
    }
//    public int[] intersect(int[] nums1, int[] nums2) {
//        List<Integer> res = new ArrayList<>();
//        List<Integer> result = new ArrayList<>();
//        int count = 0;
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums1.length; i++){
//            res.add(nums1[i]);
//        }
//        for (int j = 0; j< nums2.length; j++){
//            if (res.contains(nums2[j])){
//                result.add(nums2[j]);
//                nums2[j] = -1;
//            }
//        }
//        int[] resu = new int[result.size()];
//        for (int i = 0; i < resu.length; i++) {
//            resu[i] = result.get(i);
//        }
//        return  resu;
//    }

}
