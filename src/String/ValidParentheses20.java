package String;

import java.util.Stack;

public class ValidParentheses20 {
    public static void main(String[] args) {
        String s = "";
        ValidParentheses20 vp = new ValidParentheses20();
        System.out.println(vp.isValid(s));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() < 2) return false;
        for (char ch: s.toCharArray()){
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            } else if (ch == ')'){
                if (stack.isEmpty() || stack.peek() != '(') return false;
                else stack.pop();
            } else if (ch == ']'){
                if (stack.isEmpty() || stack.peek() != '[') return false;
                else stack.pop();
            } else if (ch == '}'){
                if (stack.isEmpty() || stack.peek() != '{') return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
