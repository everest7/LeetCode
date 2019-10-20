package Stack;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-01
 */
public class SimplifyPath71 {
    public static void main(String[] args) {
        SimplifyPath71 sp = new SimplifyPath71();
        System.out.println(sp.simplifyPath("/a/../../b/../c//.//"));
    }

    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for (String s : paths) {
            if (s.equals(".") || s.equals("")) continue;
            else if (s.equals("..")) {
                if (stack.isEmpty()) continue;
                stack.pop();
            } else {
                stack.push(s);
            }
        }
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
            if(res.charAt(0) != '/') res.insert(0, "/");
        }
        return res.toString();
    }
}
