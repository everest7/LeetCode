package String;

import java.util.Stack;

/**
 * @author Vincent
 * @Date 9/25/19
 */
public class BasicCalculatorIII772 {
    public static void main(String[] args) {
        System.out.println(calculate(" 6-4 / 2 "));
    }

    public static int calculate(String s) {
        s = s.replace(" ", "");
        int res = 0, num = 0;
        char operator = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '(') {
                int j = i;
                int cnt = 0;
                for (; i < s.length(); i++) {
                    if (s.charAt(i) == '(') cnt++;
                    if (s.charAt(i) == ')') cnt--;
                    if (cnt == 0) break;
                }
                num = calculate(s.substring(j + 1, i));
            }
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == s.length() - 1) {
                switch (operator) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                operator = ch;
                num = 0;
            }

        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
