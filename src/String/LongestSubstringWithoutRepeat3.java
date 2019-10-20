package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent
 * @Date 2019-06-11
 */
public class LongestSubstringWithoutRepeat3 {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeat3 ls = new LongestSubstringWithoutRepeat3();
        System.out.println(ls.lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;

    }
}
