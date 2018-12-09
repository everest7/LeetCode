package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        int[] candi = {2,3,6,7};
        CombinationSum39 cs = new CombinationSum39();
        System.out.println(cs.combinationSum(candi, 7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;

    }

    public void backtrack(List<List<Integer>> res, List<Integer> templist, int[] nums, int target, int start){
        if (target == 0){
            res.add(new ArrayList<>(templist));
        } else if (target > 0){
            for (int i = start; i < nums.length; i++){
                templist.add(nums[i]);
                backtrack(res, templist, nums, target - nums[i], i);
                templist.remove(templist.size() - 1);
            }
        }
    }
}
