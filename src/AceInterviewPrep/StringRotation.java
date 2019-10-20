package AceInterviewPrep;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-02
 */

/**
 * Rotate a string with given
 * direction: 1 indicates right shift, -1 indicates left shift
 * amount: shift step
 *
 */
public class StringRotation {
    public static void main(String[] args) {
        StringRotation st = new StringRotation();
        System.out.println(st.rotateString("abcde", new int[] {1, -1}, new int[] {2, 3}));
    }

    public List<String> rotateString(String s, int[] direction, int[] amount) {
        List<String> res = new ArrayList<>();
        if (direction.length != amount.length) return res;
        for (int i = 0; i < direction.length; i++) {
            res.add(rotate(s, direction[i], amount[i]));
        }
        return res;
    }

    public String rotate(String s, int dir, int step) {
        String ss = s + s;
        if (dir == -1) {
            return ss.substring(step, step + s.length());
        }
//        return ss.substring(s.length() - step, 2 * s.length() - step);
        return rotate(s, dir * -1, s.length() - step);
    }
}
