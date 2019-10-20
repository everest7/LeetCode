package Stack;

/**
 * @author Vincent
 * @Date 2019-08-25
 */
public class RemoveKDigits402 {
    public static void main(String[] args) {
//        System.out.println(removeKdigits("1432219", 3));
//        System.out.println(removeKdigits("10", 2));
        System.out.println(removeKdigits("10", 1));
    }

//    public static String removeKdigits(String num, int k) {
//        StringBuilder sb = new StringBuilder();
//        int digits = num.length() - k;
//        for (char ch : num.toCharArray()) {
//            while (k > 0 && sb.length() > 0 && ch < sb.charAt(sb.length() - 1)) {
//                sb.deleteCharAt(sb.length() - 1);
//                k--;
//            }
//            sb.append(ch);
//        }
//        int idx = 0;
//        while (idx < sb.length()) {
//            if (sb.charAt(idx) != '0') break;
//            idx++;
//        }
//        String res = sb.substring(idx).toString();
//        return idx == digits ? "0" : res;
//    }

    public static String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        // k keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when k is larger than 0
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            stk[top++] = c;
        }
        // find the index of first non-zero digit
        int idx = 0;
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits? "0": new String(stk, idx, digits - idx);
    }
}
