package Array;

/**
 * @author Vincent
 * @Date 10/14/19
 */
public class BestSightSeeingPair1014 {
    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{1,3,5}));
    }

    public static int maxScoreSightseeingPair(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int score = A[0], leftMax = A[0];
        int rightMax = A[A.length - 1] - (A.length - 1);
        for (int i = 0; i < A.length; i++) {
            leftMax = Math.max(leftMax, A[i] + i);
            left[i] = leftMax;
        }

        for (int i = A.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, A[i] - i);
            right[i] = rightMax;
        }
        int res = 0;
        for (int i = 0; i < A.length - 1; i++) {
            res = Math.max(res, left[i] + right[i + 1]);
        }
        return res;
    }
}
