package String;

/**
 * @author Vincent
 * @Date 2019-09-02
 */
public class BackspaceStringCompare844 {
    public static void main(String[] args) {
//        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }
    public static boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        for (char ch : S.toCharArray()) {
            if (ch == '#' && s.length() > 0) {
                s.deleteCharAt(s.length() - 1);
            } else if (Character.isLetter(ch)){
                s.append(ch);
            }
        }
        for (char ch : T.toCharArray()) {
            if (ch == '#' && t.length() > 0) {
                t.deleteCharAt(t.length() - 1);
            } else if (Character.isLetter(ch)) {
                t.append(ch);
            }
        }
        return s.toString().equals(t.toString());
    }
}
