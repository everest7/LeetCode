package BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Vincent
 * @Date 2019-03-13
 */
public class MaxLenRepeatedSubarray718 {
    public static void main(String[] args) {
        MaxLenRepeatedSubarray718 ml = new MaxLenRepeatedSubarray718();
        System.out.println(ml.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }

    /**
     * Binary Solution
     * Intuition: Assuming k is the max length of subarray of A and B, there must exist len(sub) = j < k
     * where sub is also subarray of A and B.
     * Starting from left = 0, right = min{len(A), len(b)} + 1, using binary search, we can find the max
     * length
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int left = 0, right = Math.min(A.length, B.length) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, A, B)) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public boolean check(int len, int[] A, int[] B) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i + len < A.length; i++) {
            set.add(Arrays.toString(Arrays.copyOfRange(A,i, i + len)));
        }
        for (int i = 0; i + len < B.length; i++) {
            if (set.contains(Arrays.toString(Arrays.copyOfRange(B,i, i + len)))){
                return true;
            }
        }
        return false;
    }

    /**
     * DP solution
     */
//    public int findLength(int[] A, int[] B) {
//        int[][] dp = new int[A.length + 1][B.length + 1];
//        int res = Integer.MIN_VALUE;
//        for (int i = A.length - 1; i >= 0; i--) {
//            for (int j = B.length - 1; j >= 0; j--) {
//                if (A[i] == B[j]) {
//                    dp[i][j] = dp[i + 1][j + 1] + 1;
//                }
//                res = Math.max(res, dp[i][j]);
//            }
//        }
//        return res;
//    }
}
