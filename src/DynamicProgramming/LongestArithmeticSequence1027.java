package DynamicProgramming;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-01
 */
public class LongestArithmeticSequence1027 {
    public static void main(String[] args) {
        LongestArithmeticSequence1027 lc = new LongestArithmeticSequence1027();
//        System.out.println(lc.longestArithSeqLengthMap(new int[] {3,6,9,12}));
        System.out.println(lc.longestArithSeqLengthInsert(new int[] {2,4,8}, new int[] {2,4,6,8,10,12}));
//        System.out.println(lc.longestAritheSeqGivenDiff(new int[] {3,6,9,12}, 3));
    }

    /**
     * Follow up: difference is given
     */
    public int longestAritheSeqGivenDiff(int[] A, int diff) {
        int[] dp = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            int num = A[i] - diff;
            if (map.containsKey(num)) {
                dp[i] = dp[map.get(num)] + 1;
            }
            map.put(A[i], i);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * DP
     * dp[i][diff] denotes the length of longest arithmetic subsequence ends with A[i] with difference diff.
     * since 0 <= A[i] <= 10000, the maximum difference we're looking for is 20000 with order[0-10000, 10000-0] => [?, 0, 10000]
     *
     */
    public int longestArithSeqLength(int[] A) {
        if (A.length < 2) return A.length;
        int[][] dp = new int[A.length][20001];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j] + 10000;
                dp[i][diff] = dp[j][diff] + 1;
                res = Math.max(res, dp[i][diff]);
            }
        }
        return res + 1;
    }

//    public int longestArithSeqLength(int[] A) {
//        int n = A.length;
//        if (n < 2) return n;
//        int res = 0;
//        Map<Integer, Integer>[] map = new Map[n];
//        for (int i = 0; i < n; i++) {
//            map[i] = new HashMap<>();
//            for (int j = 0; j < i; j++) {
//                int diff = A[i] - A[j];
//                if (map[j].get(diff) == null) {
//                    map[i].put(diff, 2);
//                } else {
//                    map[i].put(diff, map[j].get(diff) + 1);
//                }
//                res = Math.max(res, map[i].get(diff));
//            }
//        }
//        return res;
//    }

//    public int longestArithSeqLength(int[] A) {
//        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
//        int res = 2;
//        for (int i = 1; i < A.length; i++) {
//            for (int j = 0; j < i; j++) {
//                Map<Integer, Integer> m = dp.computeIfAbsent(A[i] - A[j], d -> new HashMap<>());
//                m.put(i, m.getOrDefault(j, 1) + 1);
//                res = Math.max(res, m.get(i));
//
//            }
//        }
//        return res;
//    }

//    public int longestArithSeqLength(int[] A) {
//        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
//        int res = 2;
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i + 1; j < A.length; j++) {
//                Map<Integer, Integer> m = dp.computeIfAbsent(A[j] - A[i], d -> new HashMap<>());
//                m.put(j, m.getOrDefault(i, 1) + 1);
//                res = Math.max(res, m.get(j));
//            }
//        }
//        return res;
//    }


    public static int longestArithSeqLengthMap(int[] A) {
        int res = 2;
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 0) + 1);
                res = Math.max(res, dp[i].get(diff));
            }
        }
        return res;
    }

    /**
     * Nextdoor OA
     * Given two arrays of ints, a and b, try to create an arithmetic sequence by adding ints from b into a.
     * Return the maximum length of a or -1 if there does not exist an arthimetic sequence
     * e.g. a = [2, 4, 8], b = [1, 6, 10, 12] -> a = [2, 4, 6, 8, 10, 12] -> return 6
     */
    public static int longestArithSeqLengthInsert(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        System.arraycopy(A, 0, C, 0, A.length);
        System.arraycopy(B, 0, C, A.length, B.length);
        Arrays.sort(C);
        int res = 2;
        Map<Integer, Integer>[] dp = new HashMap[C.length];
        for (int i = 0; i < C.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = C[i] - C[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dp[i].get(diff));
            }
        }
        return res == 2 ? -1 : res;
    }
}
