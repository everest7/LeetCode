package Math;

import java.util.HashSet;
import java.util.Set;

public class PerfectSquare367 {
    public static void main(String[] args) {
        PerfectSquare367 ps = new PerfectSquare367();
        System.out.println(ps.isPerfectSquare(11));
        System.out.println(ps.isPerfectSquare(196));
        System.out.println(ps.isPerfectSquare(2147483647));
    }



    // Every Perfect square number equals to 1 + 3 + 5 + 7 +...
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0){
            num -= i;
            i += 2;
        }
        return num == 0;

    }
//    public boolean isPerfectSquare(int num) {
//        long left = 1, right = num;
//        while (right >= left){
//            long mid = (left + right) / 2;
//            if (mid * mid == num) return true;
//            if (mid * mid > num) right = mid - 1;
//            if (mid * mid < num) left = mid + 1;
//        }
//        return false;
//
//    }
}
