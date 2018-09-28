package Hash;

import java.util.*;

public class ValidAnagram242 {
    public static void main(String[] args) {
        ValidAnagram242 va = new ValidAnagram242();
        String s = "accbf";
        String t = "bacc";
        System.out.println(va.isAnagram(s,t));
    }
//    public boolean isAnagram(String s, String t){
//        Map<Character,Integer> map1 = new HashMap<>();
//        Map<Character,Integer> map2 = new HashMap<>();
//        for (char ch : s.toCharArray()){
//            map1.put(ch,map1.getOrDefault(ch,0) + 1);
//        }
//        for (char ch : t.toCharArray()){
//            map2.put(ch, map2.getOrDefault(ch,0) + 1);
//        }
//        for (Map.Entry<Character,Integer> entry: map1.entrySet()){
//            if (map2.containsKey(entry.getKey())){
//                if (!entry.getValue().equals(map2.get(entry.getKey()))){
//                    return false;
//                }
//            }else {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] latter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            latter[s.charAt(i) - 'a']++;
            latter[t.charAt(i) - 'a']--;
        }
        for (int i : latter){
            if (i != 0) return false;
        }
        return true;

    }
}
