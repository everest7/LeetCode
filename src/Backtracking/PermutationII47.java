package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII47 {
    public static void main(String[] args) {
        PermutationII47 pm = new PermutationII47();
        int[] nums = {1, 1, 2};
        System.out.println(pm.permuteUnique(nums));
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        backtracking(res, new ArrayList<>(), nums, flag);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> templist, int[] nums, boolean[] flag){
        if (templist.size() == nums.length){
            res.add(new ArrayList<>(templist));
        } else {
            for (int i = 0; i < nums.length; i++){
                // Avoid tracking two duplicate elements
                if (i > 0 && nums[i] == nums[i - 1] && flag[i - 1]) {
                    continue;
                }
                if (flag[i]) continue;
                flag[i] = true;
                templist.add(nums[i]);
                backtracking(res, templist, nums, flag);
                flag[i] = false;
                templist.remove(templist.size() - 1);
            }
        }
    }
}
