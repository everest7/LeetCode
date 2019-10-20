package Heap;
import java.util.*;
/**
 * @author Vincent
 * @Date 9/17/19
 */
public class RearrangeStringKDistanceApart358 {
    public static void main(String[] args) {
//        System.out.println(rearrange("aaadbbcc", 2));
//        System.out.println(rearrange("abb", 2));
        String s = rearrangeString("aaabc", 3);
        System.out.println(s);
    }
    Set<Integer> set = new LinkedHashSet<>();
    public static String rearrangeString(String s, int k) {
        if (k <= 0) return s;
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> (freq[a - 'a'] != freq[b - 'a'] ? freq[b - 'a'] - freq[a - 'a'] : a.compareTo(b)));
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) pq.add((char)(i + 'a'));
        }
        StringBuilder sb = new StringBuilder();
        int unfinishedLen = s.length();
        while (!pq.isEmpty()) {
            List<Character> temp = new ArrayList<>();
            int cnt = Math.min(unfinishedLen, k);
            for (int i = 0; i < cnt; i++) {
                if (pq.isEmpty()) return "";
                char cur = pq.poll();
                sb.append(cur);
                freq[cur - 'a']--;
                if (freq[cur - 'a'] > 0) {
                    temp.add(cur);
                }
                unfinishedLen--;
            }
            for (char ch: temp) {
                pq.add(ch);
            }
        }
        return sb.toString();
    }

//    public static String rearrange(String s, int k) {
//        int[] count = new int[26];
//        int min = Integer.MAX_VALUE;
//        for (char ch: s.toCharArray()) {
//            count[ch - 'a']++;
//        }
//        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count[b - 'a'] != count[a - 'a'] ?
//                count[b - 'a'] - count[a - 'a'] : a.compareTo(b) );
//        for (int i = 0; i < 26; i++) {
//            if (count[i] != 0) {
//                pq.offer((char)(i + 'a'));
//            }
//        }
//        if (k <= 0) return s;
//        StringBuilder res = new StringBuilder();
//        int len = s.length();
//        while (!pq.isEmpty()){
//            int cnt = Math.min(len, k);
//            List<Character> temp = new ArrayList<>();
//            for (int m = 0; m < cnt; m++) {
//                if (pq.isEmpty()) return "";
//                char ch = pq.poll();
//                res.append(ch);
//                count[ch - 'a']--;
//                if (count[ch - 'a'] > 0) {
//                    temp.add((char)ch);
//                }
//                len--;
//            }
//            for (char ch: temp) {
//                pq.offer(ch);
//            }
//        }
//        return res.toString();
//    }
}
