package Array;

/**
 * @author Vincent
 * @Date 9/7/19
 */
public class MaximumSubarraySumOneDeletion {
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{1,-2,0,3}));
        System.out.println(maximumSum(new int[]{1,-2,-2,3}));
        System.out.println(maximumSum(new int[]{-1,-1,-1,-1}));
    }

    public static int maximumSum(int[] arr) {
        int n = arr.length;
        int[] fw = new int[n];
        int[] bw = new int[n];
        int curMax = arr[0], maxNow = arr[0];
        fw[0] = arr[0];
        for (int i = 1; i < n; i++) {
            curMax = Math.max(arr[i], curMax + arr[i]);
            maxNow = Math.max(maxNow, curMax);
            fw[i] = curMax;
        }
        int fwMax = maxNow;
        curMax = maxNow = bw[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            curMax = Math.max(arr[i], curMax + arr[i]);
            maxNow = Math.max(maxNow, curMax);
            bw[i] = curMax;
        }
        int res = Math.max(maxNow, fwMax);
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, fw[i - 1] + bw[i + 1]);
        }
        return res;
    }
}
