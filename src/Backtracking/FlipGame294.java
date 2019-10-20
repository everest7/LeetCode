package Backtracking;

/**
 * @author Vincent
 * @Date 2019-06-15
 */

import java.util.HashMap;
import java.util.Map;

/**
 * The idea is to replace every "++" with "--" and see if next player can win the game
 */
public class FlipGame294 {
    public static void main(String[] args) {
        FlipGame294 fg = new FlipGame294();
        System.out.println(fg.canWin("+++++"));
    }
    // Store string's info(win or lose) in a hashmap
    Map<String, Boolean> map = new HashMap<>();
    public boolean canWin(String s) {
        if (map.containsKey(s)) return map.get(s);
        char[] sc = s.toCharArray();
        for (int i = 1; i < sc.length; i++) {
            if (sc[i] == '+' && sc[i - 1] == '+') {
                String next = s.substring(0, i - 1) + "--" + s.substring(i + 1);
                // If next can't win, that means current player is guarantee to win
                if (!canWin(next)) {
                    map.put(s, true);
                    return true;

                }
            }
        }
        map.put(s, false);
        return false;
    }

//    public boolean canWin(String s) {
//        char[] sc = s.toCharArray();
//        for (int i = 1; i < sc.length; i++) {
//            if (sc[i] == '+' && sc[i - 1] == '+') {
//                String next = s.substring(0, i - 1) + "--" + s.substring(i + 1);
//                if (!canWin(next)) {
//                    return true;
//
//                }
//            }
//        }
//        return false;
//    }
}
