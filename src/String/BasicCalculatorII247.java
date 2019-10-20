package String;

import java.util.Stack;

/**
 * @author Vincent
 * @Date 2019-05-23
 */
public class BasicCalculatorII247 {
    public static void main(String[] args) {
        BasicCalculatorII247 bs = new BasicCalculatorII247();
        System.out.println(bs.calculate("3+2*2"));
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int num = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if (operator == '+') {
                stack.push(num);
            } else if (operator == '-') {
                stack.push(-1 * num);
            } else if (operator == '*') {
                int top = stack.pop();
                stack.push(top * num);
            } else if (operator == '/') {
                int tmp = stack.pop();
                stack.push(tmp / num);
            }
            operator = s.charAt(i);
            num = 0;
//                i++;
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
