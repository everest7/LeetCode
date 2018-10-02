package Stack;

import java.util.Stack;

public class BackStringComp844 {
    public static void main(String[] args) {
        BackStringComp844 bs = new BackStringComp844();
        String s = "aa#c";
        String t = "ab#c";
        System.out.println(bs.backspaceCompare(s,t));
    }
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));

    }
    private String build(String s){
        Stack<Character> stack1 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()){
            if (ch != '#'){
                stack1.push(ch);
            } else if (!stack1.isEmpty()){
                stack1.pop();
            }
        }
        return String.valueOf(stack1);

    }
}
