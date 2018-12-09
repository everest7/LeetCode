package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation46 {
    public static void main(String[] args) {
        Permutation46 pm = new Permutation46();
        int[] nums = {1, 2, 3};
        System.out.println(pm.permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0) return res;
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> templist, int[] nums){
        if (templist.size() == nums.length){
            res.add(new ArrayList<>(templist));
        } else {
            for (int i = 0; i < nums.length; i++){
                if (templist.contains(nums[i])) continue;
                templist.add(nums[i]);
                backtrack(res, templist, nums);
                templist.remove(templist.size() - 1);
            }
        }
    }
}
