package Backtracking;
import java.util.*;
/**
 * @author Vincent
 * @Date 9/9/19
 */
public class IncreasingSubsequences491 {
    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[] {4,6,7,7}));
        System.out.println(findSubsequences(new int[] {-8,28,68,-54,96,97,84,-32,8,-87,1,-7,-20,12,22}));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public static void backtrack(int[] nums, int cur, List<Integer> temp, List<List<Integer>> res) {
        if (cur > nums.length) return;
        if (temp.size() > 1) {
            res.add(new ArrayList<>(temp));
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = cur; i < nums.length; i++) {
            if (visited.contains(nums[i])) continue;
            if (temp.size() == 0 || nums[i] >= temp.get(temp.size() - 1)) {
                visited.add(nums[i]);
                temp.add(nums[i]);
                backtrack(nums, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
