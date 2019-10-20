package Heap;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-03
 */
public class KthSmallestPrimeFractino786 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[] {1,2,3,5}, 3)));
    }

    public static int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]> (){
            public int compare(int[] o1, int[] o2) {
                int s1 = A[o1[0]] * A[o2[1]];
                int s2 = A[o2[0]] * A[o1[1]];
                return s1 - s2;
            }
        });
        int len = A.length;
        for (int i = 0; i < len; i++) {
            pq.add(new int[]{i, len - 1});
        }
        while (--K > 0) {
            int[] pop = pq.poll();
            int i = pop[0];
            int j = pop[1];
            if (pop[1] - 1 > pop[0]) {
                pop[1]--;
                pq.add(pop);
            }
        }
        int[] res = pq.poll();
        return new int[] {A[res[0]], A[res[1]]};

    }

    /**
     * TLE!!!! O(n^2)
     * @param A
     * @param K
     * @return
     */
//    public static int[] kthSmallestPrimeFraction(int[] A, int K) {
//        TreeMap<Double, int[]> map = new TreeMap<>();
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i + 1; j < A.length; j++ ) {
//                map.put((double) A[i] / A[j], new int[] {A[i], A[j]});
//            }
//        }
//        int i = 0;
//        while (i < K - 1 && !map.isEmpty()) {
//            map.pollFirstEntry();
//            i++;
//        }
//        Map.Entry<Double, int[]> entry = map.pollFirstEntry();
//        return entry.getValue();
//    }
}
