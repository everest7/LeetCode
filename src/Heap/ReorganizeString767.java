package Heap;

import java.util.PriorityQueue;

/**
 * @author Vincent
 * @Date 2019-05-15
 */
public class ReorganizeString767 {
    public static void main(String[] args) {
        ReorganizeString767 rs = new ReorganizeString767();
        System.out.println(rs.reorganizeString("vvvlo"));
    }

    /**
     * Store the freq of each character in the string.
     * Add the <Char, freq> pair into Priority Queue.
     * Every time pop two items from the pq and append the char into result string.
     * If the freq - 1 > 0, meaning we still need to use this char, add <char, freq - 1> to the pq.
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        int[] chs = new int[26];
        for (char ch : S.toCharArray()) {
            chs[ch - 'a']++;
            if (chs[ch - 'a'] > (S.length() + 1) / 2) return "";
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int i = 0; i < 26; i++) {
            if (chs[i] > 0) {
                pq.add(new int[] {i, chs[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            int[] first = pq.poll();
            int[] second = pq.poll();
            sb.append((char)(first[0] + 'a'));
            if (first[1] > 1) {
                pq.add(new int[] {first[0], first[1] - 1});
            }
            sb.append((char)(second[0] + 'a'));
            if (second[1] > 1) {
                pq.add(new int[] {second[0], second[1] - 1});
            }
        }
        if (!pq.isEmpty()) {
            sb.append((char)(pq.poll()[0] + 'a'));
        }
        return sb.toString();
    }

//    public String reorganizeString(String S) {
//        int[] alpha = new int[26];
//        for (char ch : S.toCharArray()) {
//            alpha[ch - 'a']++;
//            if (alpha[ch - 'a'] > (S.length() + 1) / 2) {
//                return "";
//            }
//        }
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
//        for (int i = 0; i < alpha.length; i++) {
//            if (alpha[i] > 0) {
//                pq.add(new int[] {i + 97, alpha[i]});
//            }
//        }
//        StringBuilder res = new StringBuilder();
//        while (!pq.isEmpty()) {
//            int[] first = pq.peek();
//            if (res.length() == 0 || first[0] != res.charAt(res.length() - 1)) {
//                pq.poll();
//                res.append((char) first[0]);
//                if (--first[1] > 0) {
//                    pq.add(new int[] {first[0], first[1]});
//                }
//            } else {
//                int[] second = pq.poll();
//                res.append((char) second[0]);
//                if (--second[1] > 0) {
//                    pq.add(new int[] {second[0], second[1]});
//                }
//            }
//        }
//        return res.toString();
//
//    }
}
