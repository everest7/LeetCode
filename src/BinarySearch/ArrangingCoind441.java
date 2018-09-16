package BinarySearch;

public class ArrangingCoind441 {
    public static void main(String[] args) {
        ArrangingCoind441 ac = new ArrangingCoind441();
        System.out.println(ac.arrangeCoins(8));
    }
//    public int arrangeCoins(int n) {
//        long sum = 0;
//        int i = 0;
//        while(sum < n){
//            sum += i;
//            if (sum > n) return i -1;
//            i++;
//        }
//        return i - 1;
//    }

    // Using arithmetic progression sum of items formula
//    public int arrangeCoins(int n){
//        return (int)(-1 + Math.sqrt(1 + 8 * (long)n))/2;
//    }

    // Using binary search
    public int arrangeCoins(int n){
        long nLong = (long)n;
        long left = 1, right = nLong;
        while (left <= right){
            long mid = left + (right - left) / 2;

            if ((1 + mid) * mid == 2 * nLong){
                return (int)mid;
            }
            else if ((1 + mid) * mid < 2 * nLong){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return (int)left - 1;
    }
}
