package Hash;

import java.util.*;

public class GroupAnagrams49 {
    public static void main(String[] args) {
        GroupAnagrams49 ga = new GroupAnagrams49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(ga.groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs){
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> map = new HashMap<>();
        for (String st : strs){
            int[] charInt = new int[26];
            for (char ch : st.toCharArray()){
                charInt[ch - 'a']++;
            }
//            String key = String.valueOf(charInt);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charInt.length; i++){
                sb.append(charInt[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(st);
        }
        return new ArrayList(map.values());
    }
    /*
    Sort a char array.
    Two strings are anagram if they are the same after sorting in alphabetical order
     */
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> res = new ArrayList<>();
//        if (strs.length == 0) return res;
//        Map<String, List> map = new HashMap<>();
//        for (String st : strs){
//            char[] chars = st.toCharArray();
//            Arrays.sort(chars);
//            String key = String.valueOf(chars);
//            if (!map.containsKey(key)){
//                map.put(key, new ArrayList());
//            }
//            map.get(key).add(st);
//        }
//        return new ArrayList(map.values());
//    }
}
