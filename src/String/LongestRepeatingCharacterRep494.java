package String;

/**
 * @author Vincent
 * @Date 2019-05-27
 */
public class LongestRepeatingCharacterRep494 {
    public static void main(String[] args) {
        LongestRepeatingCharacterRep494 lr = new LongestRepeatingCharacterRep494();
        System.out.println(lr.characterReplacement("AABABBA", 1));
    }
    public int characterReplacement(String s, int k) {
        int l = 0, maxCnt = 0, res = 0;
        int[] letters = new int[26];
        for (int r = 0; r < s.length(); r++) {
            ++letters[s.charAt(r) - 'A'];
            maxCnt = Math.max(maxCnt, letters[s.charAt(r) - 'A']);
            while (r - l + 1 - maxCnt > k) {
                --letters[s.charAt(l) - 'A'];
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
    public int most(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }
}
