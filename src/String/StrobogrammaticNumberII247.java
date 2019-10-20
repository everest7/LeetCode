package String;
import java.util.*;
/**
 * @author Vincent
 * @Date 9/30/19
 */
public class StrobogrammaticNumberII247 {
    public static void main(String[] args) {
        System.out.println(findStrobogrammatic(3));
    }

    public static List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    public static List<String> helper(int cur, int n) {
        if (cur == 0) return new ArrayList<>(Arrays.asList(""));
        if (cur == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> tmp = helper(cur - 2, n);
        List<String> res = new ArrayList<>();
        for (String s : tmp) {
            if (cur != n) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
            res.add("8" + s + "8");
        }
        return res;
    }
}
