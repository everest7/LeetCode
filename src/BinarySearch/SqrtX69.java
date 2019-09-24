package BinarySearch;

public class SqrtX69 {
    public static void main(String[] args) {
        SqrtX69 sq = new SqrtX69();
        System.out.println(sq.mySqrt(2147395599));
    }

    // Binary Search
//    public int mySqrt(int x) {
//        long left = 0, right = x;
//        while (left <= right){
//            long mid = left + (right - left) / 2;
//            if (mid * mid < x) {
//                left = mid + 1;
//            } else if (mid * mid > x){
//                right = mid - 1;
//            } else {
//                return (int)mid;
//            }
//        }
//        return (int)left - 1;
//    }

    // Newton's Method
    public int mySqrt(int x){
        long t = x;
        while (t * t > x){
            t = (t + x / t) / 2;
        }
        return (int)t;
    }
}
