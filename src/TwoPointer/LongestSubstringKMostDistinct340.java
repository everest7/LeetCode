package TwoPointer;

/**
 * @author Vincent
 * @Date 2019-08-13
 */
public class LongestSubstringKMostDistinct340 {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(lengthOfLongestSubstringKDistinct("bacc", 2));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] ss = s.toCharArray();
        int left = 0, right = 0, res = 0, count = 0;
        int[] cnt = new int[256];
        while (right < ss.length) {
            if (cnt[ss[right]]++ == 0) {
                count++;
            }
            while (count > k && left < ss.length) {
                cnt[ss[left]]--;
                if (cnt[ss[left]] == 0) {
                    count--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

}
