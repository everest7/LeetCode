package Stack;

import Hash.LongestConsecutiveSubsequence128;

import java.util.Stack;

/**
 * @author Vincent
 * @Date 2019-07-09
 */
public class LongestValidParentheses32 {
    public static void main(String[] args) {
        LongestValidParentheses32 lv = new LongestValidParentheses32();
//        System.out.println(lv.longestValidParentheses(")(())())"));
        System.out.println(lv.longestValidParentheses(")()())"));
    }

//    public int longestValidParentheses(String s) {
//        int res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                int count = 1, j = i + 1;
//                while (j < s.length()) {
//                    if (s.charAt(j) == ')') count--;
//                    else if (s.charAt(j) == '(') count++;
//                    if (count < 0) break;
//                    j++;
//                }
//                res = Math.max(res, j - i);
//            }
//        }
//        return res;
//    }

    /**
     * Using Stack.
     * For every '(' encountered, we push its index into stack.
     * For every ')' encountered, we pop the topmost element and subtract the current index from the element we
     * just popped, this gives us the length of current valid parentheses.
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // current parentheses is not valid, start a new one
                if (stack.isEmpty()) {
                    left = i + 1; // Without need to plus one when calculating interval
                } else {
                    stack.pop(); // pop the '(' off stack
                    if (stack.isEmpty()) { // after poping, if it's empty, meaning from left bound to current i, it can form valid parentheses
                        res = Math.max(res, i - left + 1); // handling ()()() case
                    }
                    else {
                        res = Math.max(res, i - stack.peek()); // handling ((())) case
                    }
                }
            }
        }
        return res;
    }
}
