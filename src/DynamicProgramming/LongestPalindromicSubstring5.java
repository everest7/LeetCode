package DynamicProgramming;

public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        LongestPalindromicSubstring5 lp = new LongestPalindromicSubstring5();
        String s = "aaaa";
        System.out.println(lp.longestPalindrome(s));
    }

    /**
     * DP solution.
     * j - i <= 2 since there are cases like "a", "aa", "aba" in which dp[i + 1][j - 1]
     * does not exist, but we know that they are palindromic.
     * @param s
     * @return
     */
//    public String longestPalindrome(String s){
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        String res = "";
//        for (int j = 0; j < s.length(); j++){
//            for (int i = 0; i <= j; i++){
//                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
//                if (dp[i][j] && res.length() < j - i + 1){
//                    res = s.substring(i, j + 1);
//                }
//            }
//
//        }
//        return res;
//    }
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) return "";
        boolean dp[][] = new boolean[s.length()][s.length()];
        int left = 0, right = 0, len = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && len < j - i + 1) {
                    len = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }


    /*
    Expand around center
     */
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() == 0) return s;
//        int max = 0;
//        int left = 0, right = 0;
//        for (int i = 0; i < s.length(); i++){
//            int len1 = extendPalindrome(s, i, i);
//            int len2 = extendPalindrome(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > right - left){
//                left = i - (len - 1) / 2;
//                right = i + len / 2;
//            }
//        }
//        return s.substring(left, right + 1);
//    }
//
//    public int extendPalindrome(String s, int left, int right){
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
//            left--;
//            right++;
//        }
//        return right - left - 1;
//    }
}
