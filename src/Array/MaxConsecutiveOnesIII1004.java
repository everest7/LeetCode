package Array;

/**
 * @author Vincent
 * @Date 2019-05-28
 */
public class MaxConsecutiveOnesIII1004 {
    public static void main(String[] args) {
        MaxConsecutiveOnesIII1004 mc = new MaxConsecutiveOnesIII1004();
//        System.out.println(mc.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(mc.longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

    public int longestOnes(int[] A, int K) {
        int res = 0;
        int left = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                K--;
            }
            while (K < 0) {
                if (A[left] == 0) {
                    K++;
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

//    public int longestOnes(int[] A, int K) {
//        int res = 0, flipped = 0, left = 0;
//        for (int r = 0; r < A.length; r++) {
//            if (A[r] == 0) {
//                flipped++;
//            }
//            while (flipped > K) {
//                if (A[left] == 0) {
//                    flipped--;
//                }
//                left++;
//
//            }
//            res = Math.max(res, r - left + 1);
//        }
//        return res;
//    }
}
