package Backtracking;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-07-13
 */
public class WordBreakII140 {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        WordBreakII140 wd = new WordBreakII140();
        System.out.println(wd.wordBreak("catsanddog", dict));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String st : wordDict) dict.add(st);
        Map<String, List<String>> used = new HashMap<>();
        return helper(s, dict, used);
    }

    public List<String> helper(String s, Set<String> dict, Map<String, List<String>> used) {
        if (used.containsKey(s)) {
            return used.get(s);
        }
        if (s.length() == 0) {
            return null; // Base case
        }
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            if (dict.contains(left)) {
                List<String> right = helper(s.substring(i), dict, used);
                if (right == null) {
                    res.add(left);
                } else {
                    for (String st : right) {
                        res.add(left + " " + st);
                    }
                }
            }
        }
        used.put(s, res);
        return res;
    }
}
