package DynamicProgramming;

import java.util.Arrays;

public class DecodeWays91 {
    public static void main(String[] args) {
        DecodeWays91 dw = new DecodeWays91();
        System.out.println(dw.numDecodings("2263"));
    }

    /**
     * Bottom up
     */
    public int numDecodings(String s) {
        if (s.isEmpty() || (s.length() > 1 && s.charAt(0) == '0')) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < len + 1; i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

//    public int numDecodings(String s) {
//        if (s.isEmpty() || (s.length() > 1 && s.charAt(0) == '0')) return 0;
//        int[] dp = new int[s.length() + 1];
//        dp[0] = 1;
//        for (int i = 1; i < dp.length; i++) {
//            dp[i] = s.charAt(i - 1) == '0' ? 0 : dp[i - 1];
//            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
//                dp[i] += dp[i - 2];
//            }
//        }
//        return dp[s.length()];

//    }

    /**
     * DP with memorization
     * @param s
     * @return
     */
//    public int numDecodings(String s) {
//        int[] dp = new int[s.length() + 1];
//        Arrays.fill(dp, -1);
//        return numDecode(s, 0, dp);
//    }
//
//    public int numDecode(String s, int pointer, int[] dp) {
//        if (pointer >= s.length()) return 1;
//        if (dp[pointer] > -1) return dp[pointer];
//        int total = 0;
//        if (pointer + 1 <= s.length()) {
//            String first = s.substring(pointer, pointer + 1);
//            if (isValid(first)) {
//                total += numDecode(s, pointer + 1, dp);
//            }
//        }
//        if (pointer + 2 <= s.length()) {
//            String second = s.substring(pointer, pointer + 2);
//            if (isValid(second)) {
//                total += numDecode(s, pointer + 2, dp);
//            }
//        }
//        dp[pointer] = total;
//        return dp[pointer];
//    }
//    public boolean isValid(String s) {
//        if (s.length() == 0 || s.charAt(0) == '0') return false;
//        int val = Integer.parseInt(s);
//        return val >= 1 && val <= 26;
//    }
}
