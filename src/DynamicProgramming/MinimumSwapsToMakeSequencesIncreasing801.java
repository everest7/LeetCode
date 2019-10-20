package DynamicProgramming;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 9/8/19
 */
public class MinimumSwapsToMakeSequencesIncreasing801 {
    public static void main(String[] args) {
        System.out.println(minSwap(new int[] {1,3,5,4}, new int[] {1,2, 3,7}));
    }

    /**
     * DP
     * Define state:
     * swap[i] denotes the minimum swaps needed to make increasing when ith element is swapped
     * noSwap[i] denotes the minimum swaps needed to make increasing when ith element is not swapped
     *
     * Base case:
     * swap[0] = 1, noSwap[0] = 0;
     *
     * Recurrence Relation:
     * Case1: (A[i] > A[i - 1] && B[i] && B[i - 1]):
     * if you want to swap A[i], B[i], you have to swap (A[i-1], B[i-1]) as well, swap[i] = swap[i - 1] + 1
     * or you can not leave A[i], B[i] as it is, and leave(A[i-1], B[i-1]) as it is, noSwap[i] = noSwap[i - 1]
     *
     * Case2: A[i] > B[i - 1] && B[i] > A[i - 1], cross greater
     * you can either swap (A[i], B[i]), swap[i] = min{swap[i-1], noSwap[i-1] + 1}
     * or you can swap(A[i-1], B[i-1]), noSwap[i] = min{noSwap[i], swap[i-1]}
     * @param A
     * @param B
     * @return
     */
    public static int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[] swap = new int[n];
        int[] noSwap = new int[n];
        Arrays.fill(swap, n);
        Arrays.fill(noSwap, n);
        swap[0] = 1;
        noSwap[0] = 0;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                swap[i] = swap[i - 1] + 1;
                noSwap[i] = noSwap[i - 1];
            }
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                swap[i] = Math.min(swap[i], noSwap[i - 1] + 1);
                noSwap[i] = Math.min(noSwap[i], swap[i - 1]);
            }
        }
        return Math.min(swap[n - 1], noSwap[n - 1]);

    }
}
