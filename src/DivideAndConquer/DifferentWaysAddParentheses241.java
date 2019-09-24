package DivideAndConquer;

import java.util.LinkedList;
import java.util.List;

public class DifferentWaysAddParentheses241 {
    public static void main(String[] args) {
        DifferentWaysAddParentheses241 df = new DifferentWaysAddParentheses241();
        String input = "2*3-4*5";
        System.out.println(df.diffWaysToCompute(input));
    }
    // Ways("2*3-4*5") = ways("2) X ways("3-4*5") U(union) ways("2*3") X ways("4*5")
    // U(union) ways("2*3-4") X ways("5")
    // => ways("3-4*5") = ways("3") X(-) ways("4*5") U ways("3-4") X(*) ways("5)
    // =>               = -17 U -5
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*'){
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> left = diffWaysToCompute(part1);
                List<Integer> right = diffWaysToCompute(part2);
                for (int m: left){
                    for (int n: right){
                        if (ch == '+') res.add(m + n);
                        else if (ch == '-') res.add(m - n);
                        else res.add(m * n);
                    }
                }
            }

            }

        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
