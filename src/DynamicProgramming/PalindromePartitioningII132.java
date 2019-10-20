package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-08-29
 */
public class PalindromePartitioningII132 {
    public static void main(String[] args) {
//        System.out.println(minCut("aab"));
        System.out.println(minCut("ab"));
    }

    /**
     * Algo5800 notes
     * @param s
     * @return
     */
    public static int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            dp[j][j] = true;
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
            }
        }
        int[] cut = new int[s.length() ];
        for (int i = 0; i < s.length(); i++) {
            cut[i] = i;
            for (int j = 0; j <= i; j++) {
                if (dp[j][i]) {
                    cut[i] = j == 0 ? 0 : Math.min(cut[i], cut[j - 1] + 1);
                }
            }
        }
        return cut[s.length() - 1];
    }
}
