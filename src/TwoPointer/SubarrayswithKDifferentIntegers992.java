package TwoPointer;
import java.util.*;
/**
 * @author Vincent
 * @Date 10/13/19
 */
public class SubarrayswithKDifferentIntegers992 {
    public static void main(String[] args) {
//        System.out.println(subarraysWithKDistinct(new int[] {1,2,1,2,3}, 2));
        System.out.println(subarraysWithKDistinct(new int[] {1,2,1,3,4}, 3));
    }
    public static int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    public static int atMostK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0, distinct = 0;
        for (int i = 0; i < A.length; i++) {
            if (map.getOrDefault(A[i], 0) == 0) {
                distinct++;
            }
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            while (left < A.length && distinct > K) {
                map.put(A[left], map.get(A[left]) - 1);
                if (map.get(A[left]) == 0) distinct--;
                left++;
            }
//            if (distinct == K) {
                res += i - left + 1;
//            }

        }
        return res;
    }
//    public static int atMostK(int[] A, int K) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int res = 0;
//        int left = 0;
//        for (int i = 0; i < A.length; i++) {
//            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
//            while (map.size() > K) {
//                if (map.get(A[left]) > 1) {
//                    map.put(A[left], map.get(A[left]) - 1);
//                } else {
//                    map.remove(A[left]);
//                }
//                left++;
//            }
//            if (map.size() == K) {
//                res += i - left + 1;
//            }
//
//        }
//        return res;
//    }
}
