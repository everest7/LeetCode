package BinarySearch;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-13
 */
public class OddEvenJump975 {
    public static void main(String[] args) {
        System.out.println(oddEvenJumps(new int[] {10,13,12,14,15}));
    }

    public static int oddEvenJumps(int[] A) {
        int n = A.length;
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        odd[n - 1] = even[n - 1] = true;
        int res = 0;
        for (int i = n - 2; i >= 0; i--) {
            Integer greater = map.ceilingKey(A[i]);
            Integer lesser = map.floorKey(A[i]);
            if (greater != null) {
                odd[i] = even[map.get(greater)];
            }
            if (lesser != null) {
                even[i] = odd[map.get(lesser)];
            }
            if (odd[i]) {
                res++;
            }
            map.put(A[i], i);
        }
        return res;

    }
}


