package String;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-23
 */
public class LongestWordinDictthroughDeleting524 {
    public static void main(String[] args) {
        LongestWordinDictthroughDeleting524 lw = new LongestWordinDictthroughDeleting524();
        List<String> d = Arrays.asList("ale","apple","monkey","plea");
        List<String> d2 = Arrays.asList("ba","ab","a","b");
//        System.out.println(lw.findLongestWord("abpcplea", d));
        System.out.println(lw.findLongestWord("bab", d2));
    }

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String t : d) {
            if (isSubsequence(t, s) && (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0))) {
                res = t;
            }
        }
        return res;
    }

    public boolean isSubsequence(String t, String s) {
        int i = 0, j = 0;
        char[] tt = t.toCharArray();
        char[] ss = s.toCharArray();
        while (i < tt.length && j < ss.length) {
            if (tt[i] == ss[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == tt.length;
    }
}
