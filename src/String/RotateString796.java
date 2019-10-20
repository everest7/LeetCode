package String;

/**
 * @author Vincent
 * @Date 2019-05-20
 */
public class RotateString796 {
    public static void main(String[] args) {
        RotateString796 ts = new RotateString796();
        System.out.println(ts.rotateString("abcde", "cdeab"));
    }
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        for (int i = 0; i < A.length(); i++) {
            StringBuilder sb = new StringBuilder(A.substring(i, A.length()));
            sb.append(A.substring(0, i));
            if (sb.toString().equals(B)) {
                return true;
            }
        }
        return false;
    }
}
