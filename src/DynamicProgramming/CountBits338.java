package DynamicProgramming;

import java.util.Arrays;

/**
 * Review 6/19/2019
 */

public class CountBits338 {
    public static void main(String[] args) {
        CountBits338 cb = new CountBits338();
        System.out.println(Arrays.toString(cb.countBits(8)));
    }

    /**
    DP + last set bit
    P(x) = P(x & (x - 1)) + 1
     */
    public int[] countBits(int num){
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++){
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    /*
     DP + least significant bit
     P(x) = P(x/2) + (x mod 2)
     e.g 1: 01, 2: 10, 3: 11
     P(2) = P(2/2) + (2 mod 2) = 1 + 0 = 1
     P(3) = P(3/2) + (3 mod 2) = 1 + 1 = 2
     Time complexity: O(n)
     Space complexity: O(n)
     */
//    public int[] countBits(int num){
//        int[] res = new int[num + 1];
//        for (int i = 1; i <= num; i++){
//            res[i] = res[i >> 1] + (i % 2);
//        }
//        return res;
//    }

    /**
     * The first half of bits of [4, 5, 6, 7] and be generated from bits of [2, 3],
     * the second half can be generated from adding 1 to the first half.
     */
//    public int[] countBits(int num) {
//        int[] res = new int[num + 1];
//        int i = 0, b = 1;
//        while (b <= num){
//            while (i < b && i + b <= num){
//                res[b + i] = res[i] + 1;
//                i++;
//            }
//            i = 0;
//            b *= 2;
//        }
//        return res;
//    }
}
