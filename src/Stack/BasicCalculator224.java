package Stack;

import java.util.Stack;

/**
 * @author Vincent
 * @Date 2019-08-04
 */
public class BasicCalculator224 {
    public static void main(String[] args) {

//        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("2147483647"));
    }

    public static int calculate(String s) {
        s = s.replace(" ", "");
        int res = 0, sign = 1, n = s.length(), i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < n) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                res += sign * num;
                i--;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (ch == ')') {
                res *= stack.pop();
                res += stack.pop();
            }
            i++;
        }
        return res;
    }

//    public static int calculate(String s) {
//        Stack<Integer> stack = new Stack<>();
//        int num = 0;
//        int sign = 1;
//        int res = 0;
//        for (char ch : s.toCharArray()) {
//            if (Character.isDigit(ch)) {
//                num = num * 10 + ch - '0';
//            } else if (ch == '+') {
//                res += sign * num;
//                num = 0;
//                sign = 1;
//            } else if (ch == '-') {
//                res += sign * num;
//                num = 0;
//                sign = -1;
//            } else if (ch == '(') {
//                stack.push(res);
//                stack.push(sign);
//                res = 0;
//                sign = 1;
//            } else if (ch == ')') {
//                res += sign * num;
//                num = res;
//                sign = stack.pop();
//                res = stack.pop();
//            }
//        }
//        res += sign * num;
//        return res;
//    }
}
