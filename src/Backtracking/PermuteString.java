package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class PermuteString {
    public static void main(String[] args) {
        PermuteString ps = new PermuteString();
        String s = "chat";
        System.out.println(ps.permuteString(s));
    }

    public List<String> permuteString(String s){
        List<String> res = new ArrayList<>();
//        if (s.length() == 0) return res;
        Set<Integer> visited = new HashSet<>();
        permuteHelper(res,0, s,  new StringBuilder(), visited);
        return res;
    }


    public void permuteHelper(List<String> res, int cur, String s, StringBuilder chosen, Set<Integer> visited){
        if (chosen.length() == s.length()){
            res.add(chosen.toString());
            return;
        } else {
            for (int i = 0; i < s.length(); i++){
                if (visited.contains(i)) continue;
                visited.add(i);
                chosen.append(s.charAt(i));
//                s = s.substring(0, i) + s.substring(i + 1);
                permuteHelper(res, i + 1, s, chosen, visited);
//                s = s.substring(0, i) + c + s.substring(i + 1);
                chosen.deleteCharAt(chosen.length() - 1);
                visited.remove(i);
//                chosen = chosen.substring(0, chosen.length() - 1);
            }
        }
    }

//    public void permuteHelper(List<String> res, String s, int left, int right){
//        if (left == right){
//            res.add(s);
//        } else {
//            for (int i = left; i < right; i++){
//                s = swap(s, left, i);
//                permuteHelper(res, s, left + 1, right);
//                s = swap(s, left, i);
//            }
//        }
//    }
//    public String swap(String a, int i, int j)
//    {
//        char temp;
//        char[] charArray = a.toCharArray();
//        temp = charArray[i] ;
//        charArray[i] = charArray[j];
//        charArray[j] = temp;
//        return String.valueOf(charArray);
//    }

}
