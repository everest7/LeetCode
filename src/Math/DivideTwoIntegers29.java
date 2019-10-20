package Math;

/**
 * @author Vincent
 * @Date 2019-07-13
 */
public class DivideTwoIntegers29 {
    public static void main(String[] args) {
        DivideTwoIntegers29 dd = new DivideTwoIntegers29();
//        System.out.println(dd.divide(-2147483648, 2));
        System.out.println(dd.divide(15, 3));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long did = Math.abs((long)dividend), dis = Math.abs((long)divisor);
        if (divisor == 1) return sign == 1 ? (int)did : (int)-did;
        long res = 0;
        while (did >= dis) {
            long t = dis, p = 1;
            while (did >= (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            res += p;
            did -= t;
        }
        return sign < 0 ? -(int) res : (int) res;
    }

//    public int divide(int dividend, int divisor) {
//        long m = Math.abs((long)dividend); // long m = Math.abs(dividend) will not work if the dividend is Int.MIN_VALUE
//        long n = Math.abs((long)divisor), res = 0;
//        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
//        while (m >= n) {
//            long t = n, p = 1;
//            while (m >= (t << 1)) {
//                p <<= 1;
//                t <<= 1;
//            }
//            res += p;
//            m -= t;
//        }
//        return sign == 1 ? (int) res : (int) -res;
//    }
}
