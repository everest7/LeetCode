package String;

import java.util.Stack;

public class AddBinary67 {
    public static void main(String[] args) {
        AddBinary67 ab = new AddBinary67();
        String num1 = "1010";
        String num2 = "1011";
        System.out.println(ab.addBinary(num1,num2));
    }
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0){
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }
            res.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
