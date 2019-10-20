package Graph;

import java.util.ArrayList;
import java.util.*;

/**
 * @author Vincent
 */
public class RemoveInvalidParentheses301 {
    public static void main(String[] args) {
        RemoveInvalidParentheses301 rp = new RemoveInvalidParentheses301();
//        System.out.println(rp.removeInvalidParentheses("()())()"));
        System.out.println(rp.removeInvalidParentheses(")("));
    }

    /**
     * BFS
     */
    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(s);
        q.offer(s);
        boolean found = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (valid(cur)) {
                    found = true;
                    res.add(cur);
                }
                if (found) continue;
                for (int j = 0; j < cur.length(); j++) {
                    if (cur.charAt(j) != '(' && cur.charAt(j) != ')') continue;
                    String next = cur.substring(0, j) + cur.substring(j + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
        }
        return res;
    }

//    public List<String> removeInvalidParentheses(String s) {
//        List<String> res = new ArrayList<>();
//        int left = 0, right = 0;
//        for (char ch : s.toCharArray()) {
//            if (ch == '(') {
//                left++;
//            }
//            if (left == 0) {
//                if (ch == ')') {
//                    right++;
//                }
//            } else {
//                if (ch == ')') {
//                    left--;
//                }
//            }
//        }
//        dfs(res, s, left, right, 0);
//        return res;
//    }
//
//    public void dfs(List<String> res, String cur, int left, int right, int start) {
//        if (left == 0 && right == 0 && isValid(cur)) {
//            res.add(cur);
//            return;
//        }
//        for (int i = start; i < cur.length(); i++) {
//            if (i != start && cur.charAt(i) == cur.charAt(i - 1)) {
//                continue;
//            }
//            if (left > 0 && cur.charAt(i) == '(') {
//                dfs(res,  cur.substring(0, i) + cur.substring(i + 1), left - 1, right, i);
//            }
//            if (right > 0 && cur.charAt(i) == ')') {
//                dfs(res,  cur.substring(0, i) + cur.substring(i + 1), left, right - 1, i);
//            }
//        }
//    }
//
//    public boolean isValid(String s) {
//        int cnt = 0;
//        for (char ch : s.toCharArray()) {
//            if (ch == '(') {
//                cnt++;
//            } else if (ch == ')') {
//                cnt--;
//            }
//            if (cnt < 0) return false;
//        }
//        return cnt == 0;
//    }

    static int maxLen = 0;
//    public static List<String> removeInvalidParentheses(String s) {
//        List<String> res = new ArrayList<>();
//        List<String> result = new ArrayList<>();
//        dfs(res, 0, s);
//        for (String st : res) {
//            if (st.length() == maxLen) {
//                result.add(st);
//            }
//        }
//        return result;
//    }

    public static void dfs(List<String> res, int cur, String s) {
        if (valid(s)) {
            res.add(s);
            maxLen = Math.max(maxLen, s.length());
            return;
        }
        for (int i = cur; i < s.length(); i++) {
            if (i > cur && s.charAt(i) == s.charAt(i - 1)) continue;
            if (s.charAt(i) == '(') {
                dfs(res, i, s.substring(0, i) + s.substring(i + 1));
            }
            if (s.charAt(i) == ')') {
                dfs(res, i, s.substring(0, i) + s.substring(i + 1));
            }
        }
    }

    public static boolean valid(String s) {
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                cnt++;
            } else if (ch == ')') {
                cnt--;
            }
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }

//    public List<String> removeInvalidParentheses(String s) {
//        List<String> res = new ArrayList<>();
//        int left = 0, right = 0;
//        for (char ch : s.toCharArray()) {
//            if (ch == '(') {
//                left++;
//            }
//            if (left == 0) {
//                if (ch == ')') {
//                    right++;
//                }
//            } else {
//                if (ch == ')') {
//                    left--;
//                }
//            }
//        }
//        dfs(res, s, left, right, 0);
//        return res;
//    }
//
//    public void dfs(List<String> res, String cur, int left, int right, int start) {
//        if (left == 0 && right == 0 && isValid(cur)) {
//            res.add(cur);
//            return;
//        }
//        for (int i = start; i < cur.length(); i++) {
//            if (i != start && cur.charAt(i) == cur.charAt(i - 1)) {
//                continue;
//            }
//            if (left > 0 && cur.charAt(i) == '(') {
//                dfs(res,  cur.substring(0, i) + cur.substring(i + 1), left - 1, right, i);
//            }
//            if (right > 0 && cur.charAt(i) == ')') {
//                dfs(res,  cur.substring(0, i) + cur.substring(i + 1), left, right - 1, i);
//            }
//        }
//    }
//
//    public boolean isValid(String s) {
//        int cnt = 0;
//        for (char ch : s.toCharArray()) {
//            if (ch == '(') {
//                cnt++;
//            } else if (ch == ')') {
//                cnt--;
//            }
//        }
//        return cnt == 0;
//    }
}
