package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationPhoneNumber17 {
    public static void main(String[] args) {
        LetterCombinationPhoneNumber17 lcp = new LetterCombinationPhoneNumber17();
        System.out.println(lcp.letterCombinations("9"));
    }

    /*
    BFS
     */
    public List<String> letterCombinations(String digits){
        List<String> res = new LinkedList<>();
        if (digits.length() == 0) return res;
        String[] mapping = {"", "","abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while (((LinkedList<String>) res).peek().length() == i){
                String t = ((LinkedList<String>) res).remove();
                for (char ch : mapping[x].toCharArray()){
                    res.add(t + ch);
                }
            }
        }
        return res;
    }
    /**
    DFS + backtracking
     */
//    public List<String> letterCombinations(String digits) {
//        List<String> res = new ArrayList<>();
//        if (digits.length() == 0) return res;
//        String[] letter = {"", "","abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        String cur = "";
//        backtrack(res, letter, digits, cur, 0);
//        return res;
//    }
//
//    public void backtrack(List<String> res, String[] letter, String digits, String cur, int pos){
//        if (pos == digits.length()){
//            res.add(cur);
//        } else {
//            int num = digits.charAt(pos) - '0'; // get digit index
//            String str = letter[num];
//            for (int i = 0; i < str.length(); i++){
//                cur += str.charAt(i);
//                backtrack(res, letter, digits, cur, pos + 1);
//                cur = cur.substring(0, cur.length() - 1);
//            }
//        }
//
//    }
}
