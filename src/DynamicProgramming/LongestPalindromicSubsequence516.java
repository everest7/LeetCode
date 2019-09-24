package DynamicProgramming;

public class LongestPalindromicSubsequence516 {
    public static void main(String[] args) {
        LongestPalindromicSubsequence516 lp = new LongestPalindromicSubsequence516();
        String s = "cbbd";
        System.out.println(lp.longestPalindromeSubseq(s));
    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] t = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (t[i] == t[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
    /*
    Using one dimension array
     */

    /*
    DP
     */
//    public int longestPalindromeSubseq(String s) {
//        int[][] dp = new int[s.length()][s.length()];
//        for (int i = s.length() - 1; i >= 0; i--){
//            dp[i][i] = 1;
//            for (int j = i + 1; j < s.length(); j++){
//                if (s.charAt(i) == s.charAt(j)){
//                    dp[i][j] = dp[i + 1][j - 1] + 2;
//                } else {
//                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[0][s.length() - 1];
//
//    }



    /*
    Extend around center
     */
//    public int longestPalindromeSubseq(String s) {
//        for (int i = 0; i < s.length(); i++){
//            int len1 = extendPalindrome(s, i, i);
//            int len2 = extendPalindrome(s, i, i + 1);
//
//        }
//    }
//    public int extendPalindrome(String s, int left, int right){
//        while (left >= 0 && right < s.length()){
//            if (s.charAt(left) == s.charAt(right)){
//                left--;
//                right++;
//            }
//        }
//    }
}
