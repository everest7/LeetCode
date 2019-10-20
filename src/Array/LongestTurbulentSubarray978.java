package Array;

/**
 * @author Vincent
 * @Date 2019-05-27
 */
public class LongestTurbulentSubarray978 {
    public static void main(String[] args) {
        LongestTurbulentSubarray978 lb = new LongestTurbulentSubarray978();
        System.out.println(lb.maxTurbulenceSize(new int[] {4,8,12,16}));
    }
    public int maxTurbulenceSize(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                B[i] = 1;
            } else if (A[i] < A[i + 1]) {
                B[i] = -1;
            } else {
                B[i] = 0;
            }
        }
        B[A.length - 1] = 1;
        int left = 0, right = left + 1, res = 0;
        while (right < B.length) {

            if (right < B.length && B[right] * B[right - 1] < 0) {
                right++;
                res = Math.max(res, right - left + 1);
            } else {
                left = right;
                right++;
            }

        }
        return res;
    }
}
