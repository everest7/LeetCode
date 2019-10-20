package DynamicProgramming;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-06-15
 */
public class WordBreak139 {
    public static void main(String[] args) {

//        List<String> wordDict = Arrays.asList("car", "ca", "rs");
        List<String> wordDict = Arrays.asList("cat","cats", "and", "sand", "dog", "catsand", "dog");

        WordBreak139 wb = new WordBreak139();
        System.out.println(wb.wordBreak("catsanddog", wordDict));
        System.out.println(wb.minBreak("catsanddog", wordDict));
    }

    /**
     * Follow up: minimum break points
     * @param s
     * @param wordDict
     * @return
     */

    public int minBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int[] cut = new int[s.length() + 1];
        Arrays.fill(cut, s.length());
        cut[0] = 0;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && (dict.contains(s.substring(j, i)))) {
                    dp[i] = true;
                    cut[i] = Math.min(cut[i], cut[j] + 1);
                    break;
                }
            }
        }
        return dp[s.length()] ? cut[s.length()] : 0;

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && (dict.contains(s.substring(j, i)))) {
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[s.length()];
    }
//    public boolean wordBreak(String s, List<String> dict) {
//        // write your code here
//        if (s.length() == 0) return true;
//        for (int i = 0; i < s.length(); i++) {
//            if (dict.contains(s.substring(0, i))) {
//                if (wordBreak(s.substring(i), dict)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        // Base case
//        if (s.length() == 0) return true;
//        for (int i = 0; i <= s.length(); i++) {
//            String pre = s.substring(0, i);
//            String next = s.substring(i);
//            if (wordDict.contains(pre)) {
//                if (wordBreak(next, wordDict)) {
//                    return true;
//                }
////                wordDict.remove(pre);
//            }
//
//        }
//        return false;
//    }
}
