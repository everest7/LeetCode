package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-08-19
 */
public class RegularExpressionMatching10 {
    public static void main(String[] args) {
        System.out.println(isMatch("", ".*"));
    }

    /**
     * Dynamic Programming
     * Define state:
     * dp[i][j] denote whether s[1:i] matches p[1:j]
     *
     * Base Case:
     * dp[0][0] = true;
     *
     * Recurrence Relation:
     * Case 1. s[i] == p[j] or p[j] == ".", dp[i][j] = dp[i - 1][j - 1],  ("." can match any letter but empty space)
     * Case 2. p[j] == "*"
     *      Case 2.1. s[i] != p[j - 1] e.g. s[i] = "a", p[j] = "ab*", "b*" will count as empty, dp[i][j] = dp[i][j - 2]
     *      Case 2.2 e.g s[i] == p[j - 1], e.g. s[i] = "ab", p[j] = "ab*", "b*" count as single "b", dp[i][j] = = dp[i][j - 1]
     *      Case 2.3 e.g s[i] = "aaa", p[j] = "a*", "a*" count as multiple "a", dp[i][j] = dp[i - 1][j]
     *      Case 2.4 e.g. s[i] = "ab", p[j] = "abb*", "b*" count as empty, dp[i][j] = dp[i][j - 2]
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < p.length() + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                if (dp[0][j - 1] || (j > 1 && dp[0][j - 2])) {
                    dp[0][j] = true;
                }
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
