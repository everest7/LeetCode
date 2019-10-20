package DivideAndConquer;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-07-30
 */
public class ExpressionAddOperators282 {
    public static void main(String[] args) {
        ExpressionAddOperators282 es = new ExpressionAddOperators282();
//        System.out.println(es.addOperators("123456789",45));
//        System.out.println(es.addOperators("105",5));
//        System.out.println(es.addOperators2("1221",4));
        System.out.println(es.addOperators2("123456789",100));
    }

    /**
     * Follow up: simplified version, only consider + and -, return the number of valid results.
     * @param num
     * @param target
     * @return number of valid string or string array
     */

    public List<String> addOperators2(String num, int target) {
//        int[] res = new int[1];
        List<String> res = new ArrayList<>();
        helper2(res, num, target, "", 0);
        return res;
    }
    public void helper2(List<String> res, String num, int target, String curStr, int curSum) {
        if (num.length() == 0) {
            if (curSum == target) {
                res.add(curStr);
            }
            return;
        }
        for (int i = 1; i <= num.length(); i++) {
            String numStr = num.substring(0, i);
            if (numStr.length() > 1 && numStr.charAt(0) == '0') return; // exclude leading zero
            int curNum = Integer.parseInt(numStr);
            String restNum = num.substring(i);
            if (curStr.length() == 0) {
                helper2(res, restNum, target, numStr, curNum);
                helper2(res, restNum, target, "-" + numStr, -curNum);
            } else {
                helper2(res,restNum, target, curStr + "+" + curNum, curSum + curNum);
                helper2(res,restNum, target, curStr + "-" + curNum, curSum - curNum);
            }
        }
    }

    public void helper1(int[] res, String num, int target, int diff, int curSum) {
        if (num.length() == 0) {
            if (curSum == target) {
                res[0]++;
            }
            return;
        }
        for (int i = 1; i <= num.length(); i++) {
            String numStr = num.substring(0, i);
            int curNum = Integer.parseInt(numStr);
            String restNum = num.substring(i);
            helper1(res,restNum, target, curNum, curSum + curNum);
            helper1(res,restNum, target, -curNum, curSum - curNum);
        }
    }





    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(res, num, 0, 0, target, "");
        return res;
    }

    public void helper(List<String> res, String num, long diff, long curSum, int target, String curStr) {
        if (num.length() == 0) {
            if (curSum == target) {
                res.add(curStr);
            }
            return;
        }
        for (int i = 1; i <= num.length(); i++) {
            String numStr = num.substring(0, i);
            if (numStr.length() > 1 && numStr.charAt(0) == '0') return; // exclude leading zero
            long curNum = Long.parseLong(numStr);
            String nextStr = num.substring(i);
            if (curStr.length() != 0) {
                helper(res, nextStr, diff * curNum, (curSum - diff) + curNum * diff, target, curStr + "*" + numStr);
                helper(res, nextStr, curNum, curSum + curNum, target, curStr + "+" + numStr);
                helper(res, nextStr, -curNum, curSum - curNum, target, curStr + "-" + numStr);
            } else {
                helper(res, nextStr, curNum, curNum, target, numStr);
            }
        }
    }

//    List<String> res;
//    public List<String> addOperators(String num, int target) {
//        res = new ArrayList<>();
//        helper(num, target, "", 0, 0);
//        return res;
//    }
//
//    public void helper(String num, int target, String cur, long curRes, long preSum) {
//        if (curRes == (long) target && num.length() == 0) {
//            res.add(cur);
//            return;
//        }
//        for (int i = 1; i <= num.length(); i++) {
//            String curStr = num.substring(0, i);
//            if (curStr.length() > 1 && curStr.charAt(0) == '0') return;
//            long curNum = Long.parseLong(curStr);
//            String next = num.substring(i);
//            if (cur.length() != 0) {
//                helper(next, target, cur + "*" + curNum, (curRes - preSum) + curNum * preSum, preSum * curNum);
//                helper(next, target, cur + "+" + curNum, curRes + curNum, curNum);
//                helper(next, target, cur + "-" + curNum, curRes - curNum, -curNum);
//            } else {
//                helper(next, target, curStr, curNum, curNum);
//            }
//        }
//    }
}
