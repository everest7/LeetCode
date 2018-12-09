package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {
    public static void main(String[] args) {
        CombinationSumIII216 cb = new CombinationSumIII216();
        System.out.println(cb.combinationSum3(3, 9));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> templist, int nums, int sum, int start){
        if (nums == 0){
            if (sum == 0){
                res.add(new ArrayList<>(templist));
            }
        } else {
            for (int i = start; i <= 9; i++){
//                if (i > sum) return;
                templist.add(i);
                backtracking(res, templist, nums - 1, sum - i, i + 1); // Use i + 1 to avoid duplicate
                templist.remove(templist.size() - 1);
            }
        }
    }
}
