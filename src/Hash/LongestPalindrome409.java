package Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome409 {
    public static void main(String[] args) {
        LongestPalindrome409 lp = new LongestPalindrome409();
        String s = "aabbccccdd";
        String s1 = "bb";
        System.out.println(lp.longestPalindrome(s));
    }

    // Using HashSet
    public int longestPalindrome(String s){
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            if (set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                count++;
            } else {
                set.add(s.charAt(i));
            }
        }
        if (!set.isEmpty()) return count * 2 + 1;
        return count * 2;
    }

    // Using HashMap
//    public int longestPalindrome(String s) {
//        int res = 0;
//        Map<Character,Integer> map = new HashMap<>();
//        for (char ch : s.toCharArray()){
//            map.put(ch,map.getOrDefault(ch,0) + 1);
//        }
//        int maxOdd = 0;
//        for (Map.Entry<Character,Integer> entry : map.entrySet()){
//            if (entry.getValue() % 2 == 0){
//                res += entry.getValue();
//            } else {
//                maxOdd = Math.max(maxOdd,entry.getValue());
//            }
//        }
//        return res + maxOdd;
//    }
}
