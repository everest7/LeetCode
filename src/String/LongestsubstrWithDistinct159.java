package String;

import java.util.HashMap;

/**
 * @author Vincent
 * @Date 2019-05-28
 */
public class LongestsubstrWithDistinct159 {
    public static void main(String[] args) {
        LongestsubstrWithDistinct159 ld = new LongestsubstrWithDistinct159();
//        System.out.println(ld.lengthOfLongestSubstringTwoDistinct("ababffzzeee"));
        System.out.println(ld.lengthOfLongestSubstringTwoDistinct("a"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] cnt = new int[128];
        char[] chs = s.toCharArray();
        int count = 0, left = 0, res = 0;
        for (int i = 0; i < chs.length; i++) {
            if (cnt[chs[i]]++ == 0) {
                count++;
            }
            while (count > 2) {
                res = Math.max(res, i - left);
                if (--cnt[chs[left++]] == 0) {
                    count--;
                }
            }
        }
        return res;
    }

    /**
     * Using HashMap
     * @param s
     * @return
     */
//    public int lengthOfLongestSubstringTwoDistinct(String s) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        int left = 0, res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//            if (map.size() > 2) {
//                res = Math.max(res, i - left);
//                while (map.size() > 2) {
//                    char ch = s.charAt(left);
//                    if (map.get(ch) > 1) {
//                        map.put(ch, map.get(ch) - 1);
//                    } else {
//                        map.remove(ch);
//                    }
//                    left++;
//                }
//            }
//        }
//        res = Math.max(res, s.length() - left);
//        return res;
//    }

    /**
     * Using int[] as map
      * @param s
     * @return
     */
//    public int lengthOfLongestSubstringTwoDistinct(String s) {
//        int[] map = new int[128];
//        int left = 0, res = 0, count = 0, right = 0;
//        char[] ss = s.toCharArray();
//        while (right < ss.length) {
//            if (map[ss[right]]++ == 0) {
//                count++;
//            }
//            while (count > 2 && left < ss.length) {
//                map[ss[left]]--;
//                if (map[ss[left]] == 0) {
//                    count--;
//                }
//                left++;
//            }
//            res = Math.max(res, right - left + 1);
//            right++;
//        }
//
//        return res;
//    }
}
