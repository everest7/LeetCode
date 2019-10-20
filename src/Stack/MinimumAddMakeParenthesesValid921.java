package Stack;
import java.util.*;
/**
 * @author Vincent
 * @Date 9/22/19
 */
public class MinimumAddMakeParenthesesValid921 {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("()))(("));
    }

    /**
     * Using left and right variable to simulate pushing into stack
     * @param S
     * @return
     */
    public static int minAddToMakeValid(String S) {
        char[] chs = S.toCharArray();
        int left = 0, right = 0;
        for (char ch: chs) {
            if (ch == '(') left++;
            else if (ch == ')') {
                if (left > 0) left--;
                else {
                    right++;
                }
            }
        }
        return left + right;
    }

//    public static int minAddToMakeValid(String S) {
//        char[] chs = S.toCharArray();
//        int res = 0, right = 0;
//        Stack<Character> stack = new Stack<>();
//        for (char ch: chs) {
//            if (ch == '(') stack.push(ch);
//            else if (ch == ')') {
//                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
//                else if (stack.isEmpty() || stack.peek() != '(') {
//                    right++;
//                }
//            }
//        }
//        return stack.size() + right;
//    }
}
