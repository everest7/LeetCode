package String;

/**
 * @author Vincent
 * @Date 9/14/19
 */
public class ReverseSubstringInParentheses {
    public static void main(String[] args) {
//        System.out.println(reverseParentheses("(ed(et(oc))el)"));
//        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
        System.out.println(reverseParentheses("ta()usw((((a))))"));
    }

    public static String reverseParentheses(String s) {
        if (s.length() == 0) return "";
        int lastL = s.lastIndexOf("(");
        if (lastL == -1) {
            return s;
        }
        int firstR = s.indexOf(")");
        return reverseParentheses(s.substring(0, lastL) + new StringBuilder(s.substring(lastL + 1, firstR)).reverse().toString() + s.substring(firstR + 1));

    }



//    public int kConcatenationMaxSum(int[] arr, int k) {
//        int sum = 0, res = 0;
//        int m = 1000000007;
//        for (int num : arr) {
//            sum += num;
//        }
//        int[] concate = new int[arr.length * 2];
//        for (int i = 0; i < arr.length; i++) {
//            concate[i] = arr[i];
//            concate[i + arr.length] = arr[i];
//        }
//        if (sum < 0) {
//            res = maxSubSum(concate) % m;
//        } else {
//            res = maxSubSum(concate) % m + (k - 2) * sum % m;
//        }
//
//        return res < 0 ? 0 : res;
//    }
//
//    public int maxSubSum(int[] A) {
//        int max = Integer.MIN_VALUE, sum = 0;
//        int m = 1000000007;
//        for (int i = 0; i < A.length; i++) {
//            if (sum < 0)
//                sum = A[i];
//            else
//                sum += A[i];
//            if (sum > max)
//                max = sum % m;
//        }
//        return max;
//    }

}
