package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent
 * @Date 2019-03-07
 */
public class Combinations77 {
    public static void main(String[] args) {
        Combinations77 cb = new Combinations77();
        System.out.println(cb.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> temp, int n, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrack(res, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
