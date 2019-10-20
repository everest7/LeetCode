package Backtracking;
import java.util.*;
/**
 * @author Vincent
 * @Date 10/5/19
 */
public class CountVowelsPermutation {
    public static void main(String[] args) {
        System.out.println(countVowelPermutation(1));
        System.out.println(countVowelPermutation(2));
        System.out.println(countVowelPermutation(3));
        System.out.println(countVowelPermutation(4));
        System.out.println(countVowelPermutation(5));
        System.out.println(countVowelPermutation(6));
        System.out.println(countVowelPermutation(7));
        System.out.println(countVowelPermutation(8));
        System.out.println(countVowelPermutation(9));
        System.out.println(countVowelPermutation(10));
        System.out.println(countVowelPermutation(144));
    }

//    public static int countVowelPermutation(int n) {
//        List<String> res = new ArrayList<>();
//        backtrack(res, "", 0, n);
//        return res.size();
//    }

    public static int countVowelPermutation(int n) {
        int mod = 1000000007;
        if (n == 1) return 5;
        long[] a = new long[n + 1];
        long[] e = new long[n + 1];
        long[] i = new long[n + 1];
        long[] o = new long[n + 1];
        long[] u = new long[n + 1];
        a[1] = 1;
        e[1] = 1;
        i[1] = 1;
        o[1] = 1;
        u[1] = 1;
        for (int k = 1; k <= n; k++) {
            a[k] += u[k - 1] + e[k - 1] + i[k - 1];
            e[k] += a[k - 1] + i[k - 1];
            i[k] += e[k - 1] + o[k - 1];
            o[k] += i[k - 1];
            u[k] += o[k - 1] + i[k - 1];
            a[k] %= mod;
            e[k] %= mod;
            i[k] %= mod;
            o[k] %= mod;
            u[k] %= mod;
        }
        return (int)((a[n] % mod + e[n] % mod + i[n] % mod+ o[n] % mod + u[n] % mod) % mod);
    }

//    public static void backtrack(List<String> res, String sb, int cur, int n) {
//        if (cur == n) {
//            res.add(sb);
//            return;
//        }
//        if (sb.length() == 0) {
//            backtrack(res,  "a" + sb, cur + 1, n);
//            backtrack(res,  "e"+ sb, cur + 1, n);
//            backtrack(res,  "i"+ sb, cur + 1, n);
//            backtrack(res,  "o"+ sb, cur + 1, n);
//            backtrack(res,  "u"+ sb, cur + 1, n);
//        } else {
//            if (sb.charAt(0) != 'i') {
//                backtrack(res, "i" + sb, cur + 1, n);
//                if (sb.charAt(0) == 'e') {
//                    backtrack(res, "a" + sb, cur + 1, n);
//                    backtrack(res, "i" + sb, cur + 1, n);
//                } else if (sb.charAt(0) == 'a') {
//                    backtrack(res, "u" + sb, cur + 1, n);
//                    backtrack(res, "a" + sb, cur + 1, n);
//                    backtrack(res, "i" + sb, cur + 1, n);
//                } else if (sb.charAt(0) == 'u') {
//                    backtrack(res, "o" + sb, cur + 1, n);
//                }
//            } else {
//                backtrack(res, "o" + sb, cur + 1, n);
//                backtrack(res, "e" + sb, cur + 1, n);
//            }
//        }
//    }
        public static void backtrack(List<String> res, String sb, int cur, int n) {
        if (cur == n) {
            res.add(sb);
            return;
        }
        if (sb.length() == 0) {
            backtrack(res, sb + "a", cur + 1, n);
            backtrack(res, sb + "e", cur + 1, n);
            backtrack(res, sb + "i", cur + 1, n);
            backtrack(res, sb + "o", cur + 1, n);
            backtrack(res, sb + "u", cur + 1, n);
        } else {
            if (sb.charAt(sb.length() - 1) == 'a') {
                backtrack(res, sb + "e", cur + 1, n);
            } else if (sb.charAt(sb.length() - 1) == 'e') {
                backtrack(res, sb + "a", cur + 1, n);
                backtrack(res, sb + "i", cur + 1, n);
            } else if (sb.charAt(sb.length() - 1) == 'i') {
                backtrack(res, sb + "a", cur + 1, n);
                backtrack(res, sb + "e", cur + 1, n);
                backtrack(res, sb + "o", cur + 1, n);
                backtrack(res, sb + "u", cur + 1, n);
            } else if (sb.charAt(sb.length() - 1) == 'o') {
                backtrack(res, sb + "i", cur + 1, n);
                backtrack(res, sb + "u", cur + 1, n);
            } else {
                backtrack(res, sb + "a", cur + 1, n);
            }
        }
    }
//
}
