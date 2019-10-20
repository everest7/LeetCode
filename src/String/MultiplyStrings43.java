package String;

/**
 * @author Vincent
 * @Date 2019-03-12
 */
public class MultiplyStrings43 {
    public static void main(String[] args) {
        MultiplyStrings43 ms = new MultiplyStrings43();
        System.out.println(ms.multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        int[] val = new int[num1.length() + num2.length()];
        for (int j = num2.length() - 1; j >= 0; j--) {
            for (int i = num1.length() - 1; i >= 0; i--) {
                int mul = (num2.charAt(j) - '0') * (num1.charAt(i) - '0');
                int p = i + j, q = i + j + 1;
                int sum = mul + val[q];
                val[p] += sum / 10;
                val[q] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < val.length; i++) {
            if (sb.length() == 0 && val[i] == 0) continue;
            sb.append(val[i]);
        }
        return sb.toString();
    }

    /**
     * The product of two number in different digits(i, j) can be placed at res[i + j, i + j + 1].
     * @param num1
     * @param num2
     * @return
     */
//    public String multiply(String num1, String num2) {
//        int[] res = new int[num1.length() + num2.length()];
//        for (int i = num1.length() - 1; i >= 0; i--) {
//            for (int j = num2.length() - 1; j >= 0; j--) {
//                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
//                int p1 = i + j, p2 = i + j + 1;
//                int sum = product + res[p2];
//                res[p1] += sum / 10;
//                res[p2] = sum % 10;
//
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int num : res) {
//            // Ignore leading-zero
//            if (sb.length() == 0 && num == 0) continue;
//            sb.append(num);
//        }
//        return sb.length() == 0 ? "0" : new String(sb);
//    }
}
