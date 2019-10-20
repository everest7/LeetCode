package Graph;

import java.util.Stack;

/**
 * @author Vincent
 * @Date 2019-05-18
 */
public class DecodeString394 {
    public static void main(String[] args) {
        DecodeString394 ds = new DecodeString394();
        System.out.println(ds.decodeString("3[a]2[bc]"));
        System.out.println(ds.decodeString("3[a]"));
    }

    int pos = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while (pos < s.length() && s.charAt(pos) != ']') {
            if (s.charAt(pos) < '0' || s.charAt(pos) > '9') {
                sb.append(s.charAt(pos++));
            } else {
                int num = 0;
                while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
                    num = num * 10 + (s.charAt(pos) - '0');
                    pos++;
                }
                pos++;
                String sub = decodeString(s);
                pos++;
                while (num > 0) {
                    sb.append(sub);
                    num--;
                }
            }
        }
        return sb.toString();
    }

    /**
     * DFS
     */
//    int pos = 0;
//    public String decodeString(String s) {
//        return decode(s);
//    }
//
//    public String decode(String s) {
//        StringBuilder res = new StringBuilder();
//        char[] chs = s.toCharArray();
//        while (pos < s.length() && chs[pos] != ']') {
//            if (chs[pos] < '0' || chs[pos] > '9') {
//                res.append(chs[pos++]);
//            } else {
//                int cnt = 0;
//                while (chs[pos] >= '0' && chs[pos] <= '9') {
//                    cnt = cnt * 10 + (chs[pos] - '0');
//                    pos++;
//                }
//                pos++; // escape '['
//                String sub = decode(s);
//                pos++; // escape ']'
//                while (cnt > 0) {
//                    res.append(sub);
//                    cnt--;
//                }
//            }
//        }
//        return res.toString();
//    }

//    public String decodeString(String s) {
//        Stack<String> st = new Stack<>();
//        Stack<Integer> nums = new Stack<>();
//        String res = "";
//        int num = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isDigit(s.charAt(i))) {
//                num = num * 10 + (s.charAt(i) - '0');
//            } else if (s.charAt(i) == '[') {
//                nums.push(num);
//                st.push(res);
//                num = 0;
//                res = "";
//            } else if (s.charAt(i) == ']') {
//                StringBuilder sb = new StringBuilder(st.pop());
//                int times = nums.pop();
//                for (int k = 0; k < times; k++) {
//                    sb.append(res);
//                }
//                res = sb.toString();
//            } else {
//                res += s.charAt(i);
//            }
//        }
//        return res;
//    }

//    public String decodeString(String s) {
//        Stack<String> chars = new Stack<>();
//        Stack<Integer> nums = new Stack<>();
//        String res = "";
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isDigit(s.charAt(i))) {
//                int count = 0;
//                while (Character.isDigit(s.charAt(i))) {
//                    count = count * 10 + (s.charAt(i) - '0');
//                    i++;
//                }
//                nums.push(count);
//            }
//            if (s.charAt(i) == '[') {
//                chars.push(res);
//                res = "";
//            } else if (s.charAt(i) == ']') {
//                StringBuilder sb = new StringBuilder(chars.pop());
//                int repeat = nums.pop();
//                for (int j = 0; j < repeat; j++) {
//                    sb.append(res);
//                }
//                res = sb.toString();
//            } else {
//                res += s.charAt(i);
//            }
//        }
//        return res;
//    }
}
