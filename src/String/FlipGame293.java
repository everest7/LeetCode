package String;

import java.util.ArrayList;
import java.util.List;

public class FlipGame293 {
    public static void main(String[] args) {
        FlipGame293 fp = new FlipGame293();
        String s = "++++";
        System.out.println(fp.generatePossibleNextMoves(s));

    }
    public List<String> generatePossibleNextMoves(String s) {
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();
        if (s.length() == 0) return res;
        for (int i = 0; i < chars.length - 1; i++){
            if (chars[i] == '+' && chars[i+1] == '+'){
                chars[i] = chars[i+1] = '-';
                res.add(String.valueOf(chars));
                chars[i] = chars[i+1] = '+';
            }
            if (chars[i] == '-' && chars[i+1] == '-'){
                chars[i] = chars[i+1] = '+';
                res.add(String.valueOf(chars));
                chars[i] = chars[i+1] = '-';
            }

        }
        return res;
    }
}
