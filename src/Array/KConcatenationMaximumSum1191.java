package Array;

/**
 * @author Vincent
 * @Date 9/14/19
 */
public class KConcatenationMaximumSum1191 {
    public static void main(String[] args) {
        System.out.println(kConcatenationMaxSum(new int[] {1, 2}, 3));
    }

    public static int kConcatenationMaxSum(int[] arr, int k) {
        int mod = (int) Math.pow(10, 9) + 7;
        long curSum = 0, maxSum = Integer.MIN_VALUE;
        int[] accuSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            accuSum[i + 1] = accuSum[i] + arr[i];
            curSum = Math.max(curSum + arr[i], arr[i]);
            maxSum = Math.max(curSum, maxSum);
        }
        long kadSum = maxSum < 0 ? 0 : maxSum;
        if (k == 1) return (int) kadSum;
        long prefix = 0, suffix = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix = Math.max(prefix, accuSum[i + 1]);
            suffix = Math.max(accuSum[arr.length] - accuSum[i ], suffix);
        }
        if (accuSum[arr.length] <= 0) {
            return (int) Math.max((prefix + suffix) % mod, kadSum % mod);
        } else {
            return (int) Math.max((k - 2) * (accuSum[arr.length] % mod) + prefix + suffix, kadSum % mod);
        }
    }

//    int m = 1000000007;
//    public int kConcatenationMaxSum(int[] arr, int k) {
//        int sum = 0, res = 0;
//        for (int num : arr) {
//            sum = (sum + num) % m;
//        }
//        int sum1 = maxSubSum(arr);
//        if (k == 1) return sum1;
//        int[] concate = new int[arr.length * 2];
//        for (int i = 0; i < arr.length; i++) {
//            concate[i] = arr[i];
//            concate[i + arr.length] = arr[i];
//        }
//        int sum2 = maxSubSum(concate);
//        if (k == 1) return sum1;
//        if (k == 2) return sum2;
//        if (sum <= 0) return sum1;
//        return ((k - 2) * (sum % m) + sum2) % m;
//
//    }
//
//    public int maxSubSum(int[] A) {
//        int max = Integer.MIN_VALUE, sum = 0;
//        int m = 1000000007;
//        for (int i = 0; i < A.length; i++) {
//            if (sum < 0)
//                sum = A[i];
//            else
//                sum += A[i];
//            if (sum > max)
//                max = sum % m;
//        }
//        return max;
//    }
}
