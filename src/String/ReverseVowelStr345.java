package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelStr345 {
    public static void main(String[] args) {
        ReverseVowelStr345 rv = new ReverseVowelStr345();
        String s = ".,";
        System.out.println(rv.reverseVowels(s));

    }
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char[] res = s.toCharArray();
        while (i < j){
            while (i < j && !set.contains(s.charAt(i))){
                i++;
            }
            while (i < j && !set.contains(s.charAt(j))){
                j--;
            }
            if (set.contains(s.charAt(i)) && set.contains(s.charAt(j))){
                char temp = s.charAt(i);
                res[i] = s.charAt(j);
                res[j] = temp;
                i++;
                j--;

            }

        }
        return new String(res);
    }
    
//    public String reverseVowels(String s) {
//        int i = 0, j = s.length() - 1;
//        String vowel = "aeiouAEIOU";
//        char[] res = s.toCharArray();
//        while (i < j){
//            while (i < j && vowel.indexOf(s.charAt(i)) < 0){
//                i++;
//            }
//            while (i < j && vowel.indexOf(s.charAt(j)) < 0){
//                j--;
//            }
//            if (vowel.indexOf(s.charAt(i)) > 0 && vowel.indexOf(s.charAt(j)) > 0){
//                char temp = s.charAt(i);
//                res[i] = s.charAt(j);
//                res[j] = temp;
//                i++;
//                j--;
//
//            }
//
//        }
//        return new String(res);
//    }
}
