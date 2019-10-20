package Hash;

import java.util.*;

public class FirstUniChar387 {
    public static void main(String[] args) {
        FirstUniChar387 fu = new FirstUniChar387();
        String s = "leetcode";
        String s1 = "";
        System.out.println(fu.firstUniqChar(s));
//        System.out.println(fu.firstUniqChar(s1));
    }

    public int firstUniqChar(String s) {
        if (s.length() == 0) return -1;
        Queue<Integer> q = new LinkedList<>();
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
            q.add(i);
            while (!q.isEmpty()) {
                if (cnt[s.charAt(q.peek()) - 'a'] > 1) {
                    q.poll();
                } else {
                    break;
                }
            }
        }
        return q.isEmpty() ? -1 : q.peek();
    }
    // Count the frequency of each letter, return the smallest letter whose frequency is 1
//    public int firstUniqChar(String s){
//        int index = s.length();
//        for (char ch = 'a'; ch < 'z'; ch++){
//            int temp = s.indexOf(ch);
//            if (temp != -1 && temp == s.lastIndexOf(ch)){ // indexOf return -1 when not found. && check if the letter appear only once
//                index = Math.min(index,temp);
//            }
//        }
//        return index == s.length() ? -1 : index; // if index == s.length(), the answer doesn't exist
//    }

//    public int firstUniqChar(String s){
//        int res = 0;
//        int[] letters = new int[26];
//        for (char ch : s.toCharArray()){
//            ++letters[ch - 'a'];
//        }
//        for (char ch : s.toCharArray()){
//            if (letters[ch - 'a'] == 1){
//                res = s.indexOf(ch);
//                return res;
//            }
//
//        }
//        return -1;
//    }

    // Using LinkedHashMap (LinkedHashMap is just like HashMap but order when keys were inserted matters)
//    public int firstUniqChar(String s) {
//        Map<Character,Integer> map = new LinkedHashMap<>();
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < s.length(); i++){
//            if (set.contains(s.charAt(i))){
//                if (map.get(s.charAt(i)) != null){ // if the character appear more than once, then delete it from map
//                    map.remove(s.charAt(i));
//                }
//            } else {
//                map.put(s.charAt(i), i);
//                set.add(s.charAt(i));
//            }
//        }
//        return map.size() == 0 ? -1: map.entrySet().iterator().next().getValue(); // return the value of first key
//    }
}
