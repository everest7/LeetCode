package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        Subsets78 ss = new Subsets78();
        int[] nums = {1, 2, 3};
        System.out.println(ss.subsets(nums));
    }
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums.length == 0) return res;
//        Arrays.sort(nums);
//        findSubset(res, new ArrayList<>(), nums, 0);
//        return res;
//    }
//    public static void findSubset(List<List<Integer>> res, List<Integer> templist, int[] nums, int start){
//        res.add(new ArrayList<>(templist));
//        for (int i = start; i < nums.length; i++){
//            templist.add(nums[i]);
//            findSubset(res, templist, nums, i + 1);
//            templist.remove(templist.size() - 1);
//        }
//    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        backtracking(res, 0, new ArrayList<>(), nums);
        return res;
    }

    public void backtracking(List<List<Integer>> res, int pointer, ArrayList<Integer> sub, int[] nums) {
        res.add(new ArrayList<>(sub));
        for (int i = pointer; i < nums.length; i++) {
            sub.add(nums[i]);
            backtracking(res, i + 1, sub, nums);
            sub.remove(sub.size() - 1);
        }
    }
}
