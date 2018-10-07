package Stack;

import java.util.Stack;

public class ScoreOfParent856 {
    public static void main(String[] args) {
        ScoreOfParent856 sp = new ScoreOfParent856();
        String s = "(()(()))";
        System.out.println(sp.scoreOfParentheses(s));
    }

    // Using Recursion
    public int scoreOfParentheses(String s){
        return score(s, 0, s.length() - 1);
    }
    private int score(String s, int l, int r){
        // Base case
        if (r - l == 1) return 1;
        int cur = 0;
        for (int i = l; i < r; ++i){
            if (s.charAt(i) == '(') ++cur;
            if (s.charAt(i) == ')') --cur;
            if (cur == 0){
                return score(s,l,i) + score(s,i+1,r);
            }
        }
        return 2 * score(s,l+1,r-1);
    }

    // Using Stack
//    public int scoreOfParentheses(String S) {
//        Stack<Integer> stack = new Stack<>();
//        for (char ch : S.toCharArray()){
//            if (ch == '('){
//                stack.push(-1);
//            } else {
//                int cur = 0;
//                while (stack.peek() != -1){
//                    cur += stack.pop();
//                }
//                stack.pop();
//                stack.push(cur == 0 ? 1 : cur * 2);
//            }
//        }
//        int sum = 0;
//        while (!stack.isEmpty()){
//            sum += stack.pop();
//        }
//        return sum;
//    }
}
