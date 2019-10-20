package Stack;

import java.util.Stack;

/**
 * @author Vincent
 * @Date 2019-07-04
 */
public class EvaluateReversePolishNotation150 {
    public static void main(String[] args) {
        EvaluateReversePolishNotation150 ee = new EvaluateReversePolishNotation150();
        System.out.println(ee.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        Stack<Integer> stack = new Stack<>();
        for (String st : tokens) {
            switch (st) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.parseInt(st));
            }
        }
        return stack.pop();
    }

//    public int evalRPN(String[] tokens) {
//        Stack<Integer> stack = new Stack<>();
//        int first = 0, second = 0, res = 0;
//        for (String st : tokens) {
//            if (st.equals("+")) {
//                second = stack.pop();
//                first = stack.pop();
//                res = first + second;
//                stack.push(res);
//            } else if (st.equals("-")) {
//                second = stack.pop();
//                first = stack.pop();
//                res = first - second;
//                stack.push(res);
//            } else if (st.equals("*")) {
//                second = stack.pop();
//                first = stack.pop();
//                res = first * second;
//                stack.push(res);
//            } else if (st.equals("/")) {
//                second = stack.pop();
//                first = stack.pop();
//                res = first / second;
//                stack.push(res);
//            } else {
//                stack.push(Integer.parseInt(st));
//            }
//        }
//        return res;
//    }
}
