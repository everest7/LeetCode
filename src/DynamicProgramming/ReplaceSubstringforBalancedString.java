package DynamicProgramming;

/**
 * @author Vincent
 * @Date 10/19/19
 */
public class ReplaceSubstringforBalancedString {
    public static void main(String[] args) {
//        System.out.println(balancedString("QWER"));
//        System.out.println(balancedString("QQQQ"));
        System.out.println(balancedString("WQWRQQQW"));
    }

    public static int balancedString(String s) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'A']++;
        }
        int need = s.length() / 4;
        int left = 0, right = 0, res = s.length();
        while (right < s.length()) {
            if (cnt['Q' - 'A'] > need || cnt['W' - 'A'] > need || cnt['E' - 'A'] > need || cnt['R' - 'A'] > need) {
                char rightChar = s.charAt(right);
                cnt[rightChar - 'A']--;
                right++;
                if(right != s.length() - 1) continue;
            }
            res = Math.min(right - left, res);
            if (res == 0) break;
            char leftCh = s.charAt(left);
            cnt[leftCh - 'A']++;
            left++;
        }
        return res;
    }
}
