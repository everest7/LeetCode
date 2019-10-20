package Array;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-07-20
 */
public class NumberofEquivalentDominoPair1130 {
    public static void main(String[] args) {
        int[][] dominoes = new int[][]{{1,2},{2,1},{3,4},{5,6},{2,1}};
        NumberofEquivalentDominoPair1130 ne = new NumberofEquivalentDominoPair1130();
        System.out.println(ne.numEquivDominoPairs(dominoes));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] nums: dominoes) {
            int a = nums[0];
            int b = nums[1];
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            String key = a + "," + b;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int res = 0;
        for (int v: map.values()) {
            res += (v - 1) * v / 2;
        }
        return res;

    }

//    public int numEquivDominoPairs(int[][] dominoes) {
//        List<int[]> res = new ArrayList<>();
//        int ret = 0;
//        for (int i = 0; i < dominoes.length; i++) {
//            for (int j = i + 1; j < dominoes.length; j++) {
//                if (isDominoPair(dominoes[i], dominoes[j])) {
//                    ret++;
//                }
//            }
//        }
//        return ret;
//
//    }
//
//    public boolean isDominoPair(int[] a, int[] b) {
//        return (a[0] == b[0] && a[1] == b[1]) || (a[0] == b[1] && a[1] == b[0]);
//    }
}
