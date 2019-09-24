package String;

import java.util.Stack;

public class AddBinary67 {
    public static void main(String[] args) {
        AddBinary67 ab = new AddBinary67();
        String num1 = "110010";
        String num2 = "10111";
        System.out.println(ab.addBinary(num1,num2));
    }

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        char[] chs1 = a.toCharArray();
        char[] chs2 = b.toCharArray();
        int i = chs1.length - 1, j = chs2.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += (chs1[i--] - '0');
            if (j >= 0) sum += (chs2[j--] - '0');
            res.append(sum % 2);
            carry = sum / 2;
        }
        res.append(carry != 0 ? carry : "");
        return res.reverse().toString();
    }
//    public String addBinary(String a, String b) {
//        int carry = 0;
//        int i = a.length() - 1, j = b.length() - 1;
//        StringBuilder sb = new StringBuilder();
//        while (i >= 0 && j >= 0) {
//            int aa = Character.getNumericValue(a.charAt(i));
//            int bb = Character.getNumericValue(b.charAt(j));
//            i--;
//            j--;
//            sb.append((aa + bb + carry) % 2);
//            carry = (aa + bb + carry) / 2;
//        }
//        while (i >= 0) {
//            int aa = Character.getNumericValue(a.charAt(i));
//            sb.append((aa + carry) % 2);
//            carry = (aa + carry) / 2;
//            i--;
//        }
//        while (j >= 0) {
//            int bb = Character.getNumericValue(b.charAt(j));
//            sb.append((bb + carry) % 2);
//            carry = (bb + carry) / 2;
//            j--;
//        }
//        if (carry != 0) sb.append(carry);
//        return sb.reverse().toString();
//    }

//    public String addBinary(String a, String b) {
//        StringBuilder res = new StringBuilder();
//        int carry = 0;
//        int i = a.length() - 1, j = b.length() - 1;
//        while (i >= 0 || j >= 0){
//            int sum = carry;
//            if (i >= 0) {
//                sum += a.charAt(i) - '0';
//                i--;
//            }
//            if (j >= 0){
//                sum += b.charAt(j) - '0';
//                j--;
//            }
//            res.append(sum % 2);
//            carry = sum / 2;
//        }
//        if (carry != 0) res.append(carry);
//        return res.reverse().toString();
//    }
}
