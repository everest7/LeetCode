package Backtracking;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-21
 */
public class CanIWin464 {
    public static void main(String[] args) {
        CanIWin464 cw = new CanIWin464();
        System.out.println(cw.canIWin(10, 200));
    }

    boolean[] used;
    Map<String, Boolean> map;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        if (maxChoosableInteger >= desiredTotal) return true;
        char[] state = new char[maxChoosableInteger];
        for (int i = 0; i < maxChoosableInteger; i++) {
            state[i] = '0';
        }
        used = new boolean[maxChoosableInteger + 1];
        map = new HashMap<>();
        return dfs(desiredTotal, state);
    }

    public boolean dfs(int total, char[] state) {
        String key = new String(state);
        if (map.containsKey(key)) return map.get(key);
        if (total <= 0) return false;
        for (int i = 0; i < state.length; i++) {
            if (state[i] == '0') {
                state[i] = '1';
                if (total <= i + 1 || !dfs(total - (i + 1), state)) {
                    map.put(key, true);
                    state[i] = '0';
                    return true;
                }
                state[i] = '0';
            }
        }
        map.put(key, false);
        return false;
    }
}
