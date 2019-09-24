package Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWtRepeatingCharacters3 {
    public static void main(String[] args) {
        LongestSubstringWtRepeatingCharacters3 ls = new LongestSubstringWtRepeatingCharacters3();
        String s = "abcabcbd";
        String s2 = "u";
        System.out.println(ls.lengthOfLongestSubstring(s));
        System.out.println(ls.lengthOfLongestSubstring(s2));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int[] index = new int[128];
        int res = 0;
        for (int i = 0, j = 0; j < s.length(); j++){
            i = Math.max(i, index[s.charAt(j)]);
            res = Math.max(res, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return res;
    }

//    public int lengthOfLongestSubstring(String s){
//        if (s == null) return 0;
//        int res = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0, j = 0; i < s.length(); i++){
//            if (map.containsKey(s.charAt(i))){
//                j = Math.max(j, map.get(s.charAt(i)) + 1);
//            }
//            map.put(s.charAt(i), i);
//            res = Math.max(res, i - j + 1);
//        }
//        return res;
//    }

    /*
    Brute force TLE
     */
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null) return 0;
//        if (s.length() == 1) return 1;
//        int res = 0;
//        for (int i = 0; i < s.length(); i++){
//            for (int j = i + 1; j <= s.length(); j++){
//                if (allUnique(s.substring(i, j))) res = Math.max(res, j - i);
//            }
//        }
//        return res;
//    }
//
//    public boolean allUnique(String s){
//        Set<Character> set = new HashSet<>();
//        for (char ch : s.toCharArray()){
//            if (set.contains(ch)){
//                return false;
//            }
//            set.add(ch);
//
//        }
//        return true;
//    }
}
