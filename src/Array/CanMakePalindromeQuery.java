package Array;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-08-31
 */
public class CanMakePalindromeQuery {
    public static void main(String[] args) {
        System.out.println(canMakePaliQueries("abcda", new int[][] {{3,3,0}, {1,2,0},{0,3,1},{0,3,2},{0,4,1}}));
    }
    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        int[][] cnt = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); i++) {
            cnt[i + 1] = cnt[i].clone();
            cnt[i + 1][s.charAt(i) - 'a']++;
        }
        for (int[] q: queries) {
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += (cnt[q[1] + 1][i] - cnt[q[0]][i]) % 2;
            }
            res.add(sum / 2 <= q[2]);
        }
        return res;
    }

    /**
     * TLE!!
     * O(nm) where n is the number of queries and m is the maximum length of substring
     */
//    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
//        Map<Integer, int[]> dp = new HashMap<>();
//        List<Boolean> res = new ArrayList<>();
//        for (int[] query: queries) {
//            if (canFormPalindrome(s, query[0], query[1], query[2], dp)) {
//                res.add(true);
//            } else {
//                res.add(false);
//            }
//        }
//        return res;
//    }
//    public static boolean canFormPalindrome(String t, int left, int right, int k,  Map<Integer, int[]> dp) {
//        if (dp.containsKey(left)) {
//            int[] tmp = dp.get(left);
//            if (tmp[0] == right && tmp[1] == k) {
//                return tmp[2] > 0;
//            }
//        }
//        String s = t.substring(left, right + 1);
//        int[] count = new int[26];
//        for (char ch : s.toCharArray()) {
//            count[ch - 'a']++;
//        }
//        int odd = 0;
//        for (int i = 0; i < 26; i++) {
//            if ((count[i] & 1) == 1) {
//                odd++;
//            }
//        }
//        int num = odd - 2 * k;
//        if (num > 1) {
//            dp.put(left, new int[] {right, k, -1});
//            return false;
//
//        }
//        dp.put(left, new int[] {right, k, 1});
//        return true;
//    }
}
