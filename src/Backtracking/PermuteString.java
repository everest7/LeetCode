package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermuteString {
    public static void main(String[] args) {
        PermuteString ps = new PermuteString();
        String s = "chat";
        System.out.println(ps.permuteString(s));
    }

    public List<String> permuteString(String s){
        List<String> res = new ArrayList<>();
        if (s.length() == 0) return res;
//        permuteHelper(res, s, 0, s.length() - 1);
        permuteHelper(res, s, "");
        return res;
    }

    public void permuteHelper(List<String> res, String s, String chosen){
        if (s.length() == 0){
            System.out.println(chosen);
            res.add(chosen);
        } else {
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                chosen += c;
                s = s.substring(0, i) + s.substring(i + 1);
                permuteHelper(res, s, chosen);
                s = s.substring(0, i) + c + s.substring(i + 1);

                chosen = chosen.substring(0, chosen.length() - 1);
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
