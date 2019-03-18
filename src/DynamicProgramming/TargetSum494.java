package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Vincent
 * @Date 2019-03-10
 */
public class TargetSum494 {
    public static void main(String[] args) {
        TargetSum494 ts = new TargetSum494();
        System.out.println(ts.findTargetSumWays(new int[] {1,1,1,1,1}, 3));
    }

    /**
     * Recursive approach
     */
//    int res = 0;
//    public int findTargetSumWays(int[] nums, int S) {
//        calculateSum(nums, 0, S, 0);
//        return res;
//    }
//
//    public void calculateSum(int[] nums, int start, int s, int curSum) {
//        if (start == nums.length) {
//            if (curSum == s) {
//                res++;
//            }
//        } else {
//            calculateSum(nums,start + 1, s, curSum + nums[start]);
//            calculateSum(nums,start + 1, s, curSum - nums[start]);
//        }
//    }

    /**
     * Recursion with memorization
     */
    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] arr: memo) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return calSum(nums, 0, 0, S, memo);

    }

    public int calSum(int[] nums, int i, int curSum, int s, int[][] memo) {
        if (i == nums.length) {
            if (curSum == s) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (memo[i][curSum + 1000] != Integer.MIN_VALUE) {
                return memo[i][curSum + 1000];
            }
            int add = calSum(nums, i + 1, curSum + nums[i], s, memo);
            int subtract = calSum(nums, i + 1, curSum - nums[i], s, memo);
            memo[i][curSum + 1000] = add + subtract;
            return memo[i][curSum + 1000];

        }
    }
}
