package Backtracking;

import DynamicProgramming.PartitionEqualSubsetSum416;

/**
 * @author Vincent
 * @Date 2019-06-27
 */
public class PartitiontoKEqualSumSubsets698 {
    public static void main(String[] args) {
        PartitiontoKEqualSumSubsets698 ps = new PartitiontoKEqualSumSubsets698();
        int[] nums = new int[] {4, 3, 2, 3, 5, 2, 1};
        System.out.println(ps.canPartitionKSubsets(nums, 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        return helper(nums, k, 0, visited, 0, sum / k);
    }

    public boolean helper(int[] nums, int k, int index, boolean[] visited, int cur, int target) {
        if (k == 1) {
            return true;
        }
        // Once cur==target, one bucket if filled, reduce the bucket number by one
        if (cur == target) {
            return helper(nums, k - 1, 0, visited, 0, target);
        }
        for (int i = index; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (helper(nums, k, i + 1, visited, cur + nums[i], target)) return true;
            visited[i] = false;
        }
        return false;
    }
}
