package String;

/**
 * @author Vincent
 * @Date 2019-05-26
 */
public class MinimumWindowString76 {
    public static void main(String[] args) {
        MinimumWindowString76 mn = new MinimumWindowString76();
        System.out.println(mn.minWindow("cabwefgewcwaefgcf", "cae"));
//        System.out.println(mn.minWindow("a", "aa"));
    }
    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for (char ch: t.toCharArray()) {
            cnt[ch]++;
        }
        int left = 0, count = 0, res = Integer.MAX_VALUE, start = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (--cnt[chs[i]] >= 0) {
                count++;
            }
            while (count == t.length()) {
                if (res > i - left + 1) {
                    res = i - left + 1;
                    start = left; // start is only updated when a new shorter length is found
                }
                if (++cnt[chs[left++]] > 0) {
                    count--;
                }
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);
    }


//    public String minWindow(String source , String target) {
//        // write your code here
//        int[] cnt = new int[128];
//        for (char ch : target.toCharArray()) {
//            cnt[ch]++;
//        }
//        int min = Integer.MAX_VALUE;
//        int left = 0, right = 0, count = 0, start = 0;
//        while (right < source.length()) {
//            if (--cnt[source.charAt(right)] >= 0) {
//                count++;
//            }
//            while (count == target.length()) {
//                if (min > right - left + 1) {
//                    min = right - left + 1;
//                    start = left;
//                }
//                if (++cnt[source.charAt(left++)] > 0) {
//                    count--;
//                }
//
//            }
//            right++;
//        }
//        return min == Integer.MAX_VALUE ?  "" : source.substring(start, start + min);
//    }

//    public String minWindow(String s, String t) {
//        if (s.length() < t.length()) return minWindow(t, s);
//        String res = "";
//        if (s.length() == 0 || t.length() == 0) return res;
//        int[] cnt = new int[128];
//        char[] sc = s.toCharArray();
//        char[] tc = t.toCharArray();
//        int min = Integer.MAX_VALUE, left = 0, count = t.length(), start = 0;
//        for (int i = 0; i < tc.length; i++) {
//            cnt[tc[i]]++;
//        }
//        for (int i = 0; i < sc.length; i++) {
//            if (cnt[sc[i]]-- > 0) {
//                count--;
//            }
//            while (count == 0) {
//                if (min > i - left + 1) {
//                    min = i - left + 1;
//                    start = left;
//                }
//                if (cnt[sc[left++]]++ == 0) {
//                    count++;
//                }
//            }
//        }
//        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
//    }

//    public String minWindow(String s, String t) {
//        String res = "";
//        if (s.length() == 0 || t.length() == 0) return res;
//        int[] cnt = new int[128];
//        int left = 0, min = Integer.MAX_VALUE, count = 0;
//        for (char ch : t.toCharArray()) {
//            cnt[ch]++;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            // If the current char in S is in T, increment the count
//            if (--cnt[s.charAt(i)] >= 0) ++count;
//            // when all characters have been found
//            while (count == t.length()) {
//                if (min > i - left + 1) {
//                    min = i - left + 1;
//                    res = s.substring(left, left + min);
//                }
//                // exclude the first character and looking for next possible solution
//                if (++cnt[s.charAt(left)] > 0) --count;
//                left++;
//            }
//        }
//        return res;
//    }
}
