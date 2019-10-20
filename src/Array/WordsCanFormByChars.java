package Array;

/**
 * @author Vincent
 * @Date 2019-08-17
 */
public class WordsCanFormByChars {
    public static void main(String[] args) {

    }

    public int countCharacters(String[] words, String chars) {
        int[] chs = new int[26];
        for (char ch : chars.toCharArray()) {
            chs[ch - 'a']++;
        }
        int res = 0;
        for (String s : words) {
            if (canForm(s, chs)) {
                res += s.length();
            }
        }
        return res;
    }

    public boolean canForm(String s, int[] chs) {
        int[] copy = new int[26];
        for (int i = 0; i < 26; i++) {
            copy[i] = chs[i];
        }
        for (char ch : s.toCharArray()) {
            copy[ch - 'a']--;
            if (copy[ch - 'a'] < 0) return false;
        }
        return true;
    }
}
