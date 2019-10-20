package Stack;

import java.util.Stack;

/**
 * @author Vincent
 * @Date 2019-07-06
 */
public class BasicCalculatorII227 {
    public static void main(String[] args) {
        BasicCalculatorII227 bs = new BasicCalculatorII227();
        System.out.println(bs.calculate("3+2*2"));
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        int res = 0, num = 0;
        char operator = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (!Character.isDigit(ch) || i == s.length() - 1) {
                if (operator == '+') {
                    stack.push(num);
                } else if (operator == '-') {
                    stack.push(-num);
                } else if (operator == '*') {
                    stack.push(stack.pop() * num);
                } else if (operator == '/') {
                    stack.push(stack.pop() / num);
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

//    public int calculate(String s) {
//        if (s.length() == 0 || s == null) return 0;
//        int res = 0, num = 0;
//        char operator = '+';
//        Stack<Integer> number = new Stack<>();
//        char[] st = s.toCharArray();
//        for (int i = 0; i < st.length; i++) {
//            if (st[i] > '0') {
//                num = st[i] - '0';
//            }
//            if ((st[i] < '0' && st[i] != ' ') || i == st.length - 1) {
//                if (operator == '+') number.push(num);
//                if (operator == '-') number.push(-num);
//                if (operator == '*') {
//                    int temp = number.pop() * num;
//                    number.push(temp);
//                }
//                if (operator == '/') {
//                    int temp = number.pop() / num;
//                    number.push(temp);
//                }
//                operator = st[i];
//                num = 0;
//            }
//        }
//        while (!number.isEmpty()) {
//            res += number.pop();
//        }
//        return res;
//    }
}
