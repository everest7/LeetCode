package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public static void main(String[] args) {
        GenerateParentheses22 gp = new GenerateParentheses22();
        System.out.println(gp.generateParenthesis(2));
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        backtrack(res, "", n, n);
        return res;
    }
    public void backtrack(List<String> res, String s, int left, int right){
        if (left == 0 && right ==0){
            res.add(s);
        } else {
//            if (left > right){
//                backtrack(res, s + "(", left - 1, right);
//            }
            if (left < right){
                backtrack(res, s + ")", left, right - 1);
            }
            if (left > 0){
                backtrack(res, s + "(", left - 1, right);
            }
        }
    }
}
