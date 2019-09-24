package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII90 {
    public static void main(String[] args) {
        SubsetsII90 ss = new SubsetsII90();
        int[] nums = {1,2,2};
        System.out.println(ss.subsetsWithDup(nums));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> templsit, int[] nums, int start){
        res.add(new ArrayList<>(templsit));
        for (int i = start; i < nums.length; i ++){
            if (i > start && nums[i] == nums[i - 1]) continue;
            templsit.add(nums[i]);
            backtracking(res, templsit, nums, i + 1);
            templsit.remove(templsit.size() - 1);
        }
    }
}
