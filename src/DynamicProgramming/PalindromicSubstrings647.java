package DynamicProgramming;

public class PalindromicSubstrings647 {
    public static void main(String[] args) {
        String s = "abc";
        PalindromicSubstrings647 ps = new PalindromicSubstrings647();
        System.out.println(ps.countSubstrings(s));
    }


    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = (s.charAt(j) == s.charAt(i)) && (i - j <= 2 || dp[j + 1][i - 1]);
                res += dp[j][i] ? 1 : 0;
            }
        }
        return res;
    }
    /*
    DP
     */
//    public int countSubstrings(String s){
//        if (s == null || s.length() == 0) return 0;
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        int res = 0;
//        for (int j = 0; j < s.length(); j++){
//            for (int i = 0; i <= j; i++){
//                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
//                if (dp[i][j]){
//                    res++;
//                }
//            }
//        }
//        return res;
//    }


    /*
    Extend around center
     */

//    int count = 0;
//    public int countSubstrings(String s) {
//        for (int i = 0; i < s.length(); i++){
//            extendPalindrome(s, i, i); // odd length
//            extendPalindrome(s, i, i + 1); // even length
//        }
//        return count;
//    }
//    public void extendPalindrome(String s, int left, int right){
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
//            count++;
//            left--;
//            right++;
//        }
//    }

}
