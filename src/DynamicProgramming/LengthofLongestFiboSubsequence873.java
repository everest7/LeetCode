package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Vincent
 * @Date 2019-03-09
 */
public class LengthofLongestFiboSubsequence873 {
    public static void main(String[] args) {
        LengthofLongestFiboSubsequence873 lf = new LengthofLongestFiboSubsequence873();
        System.out.println(lf.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5}));
    }

    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        int[][] dp = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            Arrays.fill(dp[i], 2);
        }
        for (int j = 0; j < A.length; j++) {
            for (int k = j + 1; k < A.length; k++) {
                int ai = A[k] - A[j];
                if (ai >= A[j]) break;
                if (map.containsKey(ai)) {
                    int i = map.get(ai);
                    dp[j][k] = dp[i][j] + 1;
                    res = Math.max(res, dp[j][k]);
                }
            }
        }
        return res;
    }
}
