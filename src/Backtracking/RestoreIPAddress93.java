package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent
 * @Date 2019-06-13
 */
public class RestoreIPAddress93 {
    public static void main(String[] args) {
        RestoreIPAddress93 rp = new RestoreIPAddress93();
        System.out.println(rp.restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) return res;
        dfs(res, s, "", 1);
        return res;
    }

    public void dfs(List<String> res, String s, String cur, int field) {
        if (field == 4 && s.length() == 0) {
            res.add(cur.substring(1)); // remove the prefix "."
        } else if (field == 4 || s.length() == 0) {
            return; // not valid
        }
        dfs(res, s.substring(1), cur + "." + s.substring(0, 1), field + 1);
        if (s.charAt(0) != '0' && s.length() > 1) {
            dfs(res, s.substring(2), cur + "." + s.substring(0, 2), field + 1);
            if (s.length() > 2 && Integer.valueOf(s.substring(0, 3)) <= 255) {
                dfs(res, s.substring(3), cur + "." + s.substring(0, 3), field + 1);
            }
        }
    }
}
