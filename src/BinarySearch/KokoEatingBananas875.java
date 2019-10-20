package BinarySearch;

/**
 * @author Vincent
 * @Date 2019-09-01
 */
public class KokoEatingBananas875 {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[] {3,6,7,11}, 8));
    }

    /**
     * Count directly.
     * @param piles
     * @param H
     * @return
     */
    public static int minEatingSpeed(int[] piles, int H) {
        int left = 1, right = 1_000_000_000;
        while (left < right) {
            int mid = left + (right - left) / 2, cnt = 0;
            for (int pile: piles) {
                cnt += (pile + mid - 1) / mid;
            }
            if (cnt <= H) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

//    public static int minEatingSpeed(int[] piles, int H) {
//        int left = 1, right = (int) Math.pow(10, 9);
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (possible(piles, H, mid)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }
//
//    public static boolean possible(int[] piles, int H, int K) {
//        int cnt = 0;
//        for (int i = 0; i < piles.length; i++) {
//            cnt += (int) Math.ceil((double) piles[i] / K);
//        }
//        return cnt <= H;
//    }
}
