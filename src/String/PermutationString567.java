package String;

/**
 * @author Vincent
 * @Date 2019-05-26
 */
public class PermutationString567 {
    public static void main(String[] args) {
        PermutationString567 ps = new PermutationString567();
        System.out.println(ps.checkInclusion("ab", "eidbaooo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        for (char ch : s1.toCharArray()) {
            cnt[ch - 'a']++;
        }
        int left = 0;
        for (int i = 0; i < s2.length(); i++) {
            cnt[s2.charAt(i) - 'a']--;
            while (cnt[s2.charAt(i) - 'a'] < 0) {
                cnt[s2.charAt(left) - 'a']++;
                left++;
            }
            if (i - left + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }

//    public boolean checkInclusion(String s1, String s2) {
//        if (s1.length() > s2.length()) return false;
//        int[] chars = new int[26];
//        int[] chars2 = new int[26];
//        for (int i = 0; i < s1.length(); i++) {
//            chars[s1.charAt(i) - 'a']++;
//            chars2[s2.charAt(i) - 'a']++;
//        }
//        if (equalArray(chars, chars2)) return true;
//        int left = 0;
//        for (int right = s1.length(); right < s2.length(); right++) {
//            chars2[s2.charAt(right) - 'a']++;
//            chars2[s2.charAt(right - s1.length()) - 'a']--;
//            if (equalArray(chars, chars2)) return true;
//        }
//        return false;
//    }

//    public boolean checkInclusion(String s1, String s2) {
//        int[] chars = new int[26];
//        int[] chars2 = new int[26];
//        for (char ch : s1.toCharArray()) {
//            chars[ch - 'a']++;
//        }
//        int left = 0;
//        for (int right = 0; right < s2.length(); right++) {
//            chars2[s2.charAt(right) - 'a']++;
//            while (right - left + 1 > s1.length()) {
//                chars2[s2.charAt(left) - 'a']--;
//                left++;
//            }
//            if (equalArray(chars, chars2)) return true;
//        }
//        return false;
//    }
    public boolean equalArray(int[] A, int[] B) {
        for (int i = 0; i < 26; i++) {
            if (A[i] != B[i]) return false;
        }
        return true;
    }
}
