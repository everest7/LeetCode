package Backtracking;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-29
 */
public class PalindromePartitioning131 {
    public static void main(String[] args) {
        PalindromePartitioning131 pp = new PalindromePartitioning131();
        System.out.println(pp.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
            }
        }

        backtrack(res, 0, dp, s, new ArrayList<>());
        return res;
    }

    public void backtrack(List<List<String>> res, int index, boolean[][] dp, String s, List<String> temp) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                temp.add(s.substring(index, i + 1));
                backtrack(res, i + 1, dp, s, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
