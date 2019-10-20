package String;

/**
 * @author Vincent
 * @Date 2019-07-30
 */
public class ValidWordAbbreviation408 {
    public static void main(String[] args) {
        ValidWordAbbreviation408 va = new ValidWordAbbreviation408();
        System.out.println(va.validWordAbbreviation("internationalization", "i5a11o1"));
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        char[] words = word.toCharArray();
        char[] abbrs = abbr.toCharArray();
        int i = 0, j = 0;
        while (i < words.length && j < abbrs.length) {
            if (abbrs[j] > '0' && abbrs[j] < '9') {
                if (abbrs[j] == '0') return false;
                int val = 0;
                while (j < abbrs.length && abbrs[j] > '0' && abbrs[j] < '9') {
                    val = val * 10 + (abbrs[j] - '0');
                    j++;
                }
                i += val;
            } else {

                if (words[i++] != abbrs[j++]) {
                    return false;
                }
            }

        }
        return true;
    }
}
