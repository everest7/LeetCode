package TwoPointer;

/**
 * @author Vincent
 * @Date 9/28/19
 */
public class GetEqualSubstringWithinBudget {
    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "acde", 0));
        System.out.println(equalSubstring("abcd", "cdef", 3));
        System.out.println(equalSubstring("abcd", "bcdf", 3));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int[] diff = new int[s.length()];
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        for (int i = 0; i < Math.min(chs.length, cht.length); i++) {
            diff[i] = Math.abs(chs[i] - cht[i]);
        }
        int left = 0, res = 0, count = 0;
        for (int i = 0; i < diff.length; i++) {
            count += diff[i];
            while (count > maxCost) {
                count -= diff[left];
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
