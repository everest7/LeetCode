package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinString438 {
    public static void main(String[] args) {
        String s = "caebabacd";
        String p = "abc";
        FindAllAnagramsinString438 fa = new FindAllAnagramsinString438();
        System.out.println(fa.findAnagrams(s, p));
//        System.out.println(fa.findFirstAnagram(s, p));
    }
    public String findFirstAnagram(String s, String p) {
        int[] cnt = new int[26];
        for (char ch : p.toCharArray()) {
            cnt[ch - 'a']++;
        }
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']--;
            while (cnt[s.charAt(i) - 'a'] < 0) {
                cnt[s.charAt(left++) - 'a']++;
            }
            if (i - left == p.length() - 1) {
                return s.substring(left, left + p.length());
            }
        }
        return "";
    }

    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> res = new ArrayList<>();
//        int[] cnt = new int[26];
//        for (char ch : p.toCharArray()) {
//            cnt[ch - 'a']++;
//        }
//        char[] chs = s.toCharArray();
//        int left = 0;
//        for (int i = 0; i < chs.length; i++) {
//            cnt[chs[i] - 'a']--;
//            while (cnt[chs[i] - 'a'] < 0) {
//                cnt[chs[left++] - 'a']++;
//            }
//            if (i - left == p.length() - 1) {
//                res.add(left);
//            }
//        }
//        return res;
        List<Integer> res = new ArrayList<>();
        int[] cnt = new int[256];
        for (char ch : p.toCharArray()) {
            cnt[ch]++;
        }
        char[] chs = s.toCharArray();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']--;
            while (cnt[s.charAt(i) - 'a'] < 0) {
                cnt[s.charAt(left++) - 'a']++;
            }
            if (i - left + 1 == p.length()) {
                res.add(left);
            }
        }
        return res;
    }
    /*
    Sliding window. Using array instead of hashmap
     */
//    public List<Integer> findAnagrams(String s, String p){
//        List<Integer> res = new ArrayList<>();
//        int[] count = new int[256];
//        int begin = 0, end = 0;
//        char[] chars = s.toCharArray();
//        for (char ch : p.toCharArray()){
//            count[ch]++;
//        }
//        while (end < s.length()){
//            char c = chars[end];
//            count[c]--;
//            end++;
//            while (count[c] < 0){
//                count[chars[begin]]++;
//                begin++;
//            }
//            if (end - begin == p.length()){
//                res.add(begin);
//            }
//        }
//        return res;
//
//    }
    /*
    Sliding window
     */
//    public List<Integer> findAnagrams(String s, String p){
//        List<Integer> res = new ArrayList<>();
//        Map<Character, Integer> map = new HashMap<>();
//        if (p.length() > s.length()){
//            return res;
//        }
//        for (char ch : p.toCharArray()){
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        int counter = map.size();
//        int begin = 0, end = 0;
//        while (end < s.length()){
//            char ch = s.charAt(end);
//            if (map.containsKey(ch)){
//                map.put(ch, map.get(ch) - 1);
//                if (map.get(ch) == 0){
//                    counter--;
//                }
//            }
//            end++;
//            while (counter == 0){
//                char tempc = s.charAt(begin);
//                if (map.containsKey(tempc)){
//                    map.put(tempc, map.get(tempc) + 1);
//                    if (map.get(tempc) > 0){
//                        counter++;
//                    }
//                }
//                if (end - begin == p.length()){
//                    res.add(begin);
//                }
//                begin++;
//            }
//        }
//        return res;
//    }

//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> res = new ArrayList<>();
//        int len = p.length();
//        for (int i = 0; i < s.length() - len + 1; i++){
//            String sub = s.substring(i, i + len);
//            if (isAnagram(sub, p)){
//                res.add(i);
//            }
//        }
//        return res;
//
//    }
//    public boolean isAnagram(String s, String p){
//        int[] latter = new int[26];
//        for (int i = 0; i < s.length(); i++){
//            latter[s.charAt(i) - 'a']++;
//            latter[p.charAt(i) - 'a']--;
//        }
//        for (int i : latter){
//            if (i != 0){
//                return false;
//            }
//        }
//        return true;
//    }
}
