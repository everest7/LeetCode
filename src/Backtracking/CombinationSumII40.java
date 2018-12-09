package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {
    public static void main(String[] args) {
        CombinationSumII40 cb = new CombinationSumII40();
        int[] candi = {2,5,2,1,2};
        System.out.println(cb.combinationSum2(candi, 5));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;

    }
    public void backtrack(List<List<Integer>> res, List<Integer> templist, int[] nums, int target, int start){
        if (target == 0){
            res.add(new ArrayList<>(templist));
        } else if (target > 0){
            for (int i = start; i < nums.length; i++){
                if (i > start && nums[i] == nums[i - 1]){ // Avoid
                    continue;
                }
                templist.add(nums[i]);
                backtrack(res, templist, nums, target - nums[i], i + 1);
                templist.remove(templist.size() - 1);
            }
        }
    }
}
