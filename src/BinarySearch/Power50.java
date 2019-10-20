package BinarySearch;

/**
 * @author Vincent
 * @Date 2019-05-09
 */
public class Power50 {
    public static void main(String[] args) {
        Power50 p = new Power50();
        System.out.println(p.myPow(-1, -2147483648));
    }
//    public double myPow(double x, int n) {
//         if(n == 0)
//             return 1;
//         if(n<0){
//             n = -n;
//             x = 1/x;
//         }
//         return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
//    }

    public double myPow(double x, int n) {
        double res = 1;
        long pow = Math.abs((long)n);
        while (pow > 0) {
            res = res * x;
            pow--;
        }
        return n < 0 ? 1 / res : res;
    }
}
