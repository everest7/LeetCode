package Hash;

import java.util.*;

public class FindDifference389 {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        FindDifference389 fd = new FindDifference389();
        System.out.println(fd.findTheDifference(s, t));
    }
    public char findTheDifference(String s, String t){
        int n = 0;
        for (char ch : t.toCharArray()){
            n += (int) ch;
        }
        for (char ch : s.toCharArray()){
            n -= (int) ch;
        }
        return (char) n;
    }
//    public char findTheDifference(String s, String t) {
//
//        Map<Character, Integer> map = new HashMap<>();
//        for (char ch : t.toCharArray()){
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        for (char ch : s.toCharArray()){
//            map.put(ch, map.get(ch) - 1);
//        }
//        char ch = ' ';
//        for (Map.Entry<Character, Integer> entry : map.entrySet()){
//            if (entry.getValue() != 0){
//                ch = entry.getKey();
//
//            }
//        }
//
//        return ch;
//    }


}
