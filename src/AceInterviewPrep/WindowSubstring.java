package AceInterviewPrep;

/**
 * @author Vincent
 * @Date 2019-08-03
 */
public class WindowSubstring {
    public static void main(String[] args) {
        System.out.println(windowSubstring("ABCCBA", "ABC"));
        System.out.println(windowSubstring("ABBCZBAC", "ABC"));
    }

    public static int windowSubstring(String s, String t) {
        int result = 0;
        int left = 0, right = 0, count = 0;
        int[] cnt = new int[128];
        for(char ch : t.toCharArray()) {
            cnt[ch]++;
        }
        while (right < s.length()) {
            if (--cnt[s.charAt(right)] >= 0) {
                count++;
            }
            while (count == t.length()) {
                result += (s.length() - right);
                if (++cnt[s.charAt(left++)] > 0) {
                    count--;
                }
            }
            right++;
        }
        return result;
    }
}
