package Trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Vincent
 * @Date 2019-06-15
 */
public class LongestWordInDict720 {
    public static void main(String[] args) {
        LongestWordInDict720 lw = new LongestWordInDict720();
        System.out.println(lw.longestWord(new String[] { "w","wo","wor","worl", "world"}));
    }

    public String longestWord(String[] words) {
        Set<String> set = new HashSet<String>();
        for (String s : words) set.add(s);
        // Sort strings such that for string with same prefix: longer comes forst
        Arrays.sort(words, (a, b) -> (a.length() == b.length() ? a.compareTo(b) : b.length() - a.length()));
        String res = "";
        for (String s : words) {
            boolean valid = true;
            for (int i = 1; i < s.length(); i++) {
                if (!set.contains(s.substring(0, i))) {
                    valid = false;
                    break;
                }
            }
            if (valid) return s;
        }
        return "";
    }
}
