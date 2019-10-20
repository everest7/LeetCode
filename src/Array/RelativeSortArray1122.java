package Array;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-07-13
 */
public class RelativeSortArray1122 {
    public static void main(String[] args) {
        RelativeSortArray1122 rs = new RelativeSortArray1122();
        System.out.println(Arrays.toString(rs.relativeSortArray(new int[] {2,3,1,3,2,4,6,7,9,2,19}, new int[] {2,1,4,3,9,6})));
    }

//    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        Map<Integer, Integer> map = new HashMap<>();
//        Set<Integer> set = new HashSet();
//        for (int i = 0; i < arr2.length; i++) {
//            map.put(arr2[i], i);
//
//        }
//        Deque<Integer> deque = new LinkedList<>();
//        deque.add(arr1[0]);
//        List<Integer> extra = new ArrayList<>();
//        for (int i = 1 ; i < arr1.length; i++) {
//            if (!map.containsKey(arr1[i])) {
//                extra.add(arr1[i]);
//            } else {
//                if (map.get(deque.peekFirst()) < map.get(arr1[i])) {
//                    deque.addLast();
//                }
//            }
//
//        }
//        int[] ret = new int[res.size()];
//        for (int i = 0; i < res.size(); i++) {
//            ret[i] = res.get(i);
//        }
//        return ret;
//    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(arr1);
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    res.add(arr2[i]);
                    arr1[j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != Integer.MAX_VALUE) {
                res.add(arr1[i]);
            }
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;

    }


}
