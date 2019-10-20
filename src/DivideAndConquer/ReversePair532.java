package DivideAndConquer;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-05-21
 */
public class ReversePair532 {
    public static void main(String[] args) {
        ReversePair532 rp = new ReversePair532();
        int[] nums = new int[] {2,4,1,3,5};
        System.out.println(rp.reversePairs(nums));
    }
    public long reversePairs(int[] A) {
        // write your code here
        if (A == null || A.length == 0) return 0;
        return countInv(A, 0, A.length - 1);
    }

    public int countInv(int[] A, int begin, int end) {
        if (begin >= end) return 0;
        int mid = (begin + end) / 2;
        int x = countInv(A, begin, mid);
        int y = countInv(A, mid + 1, end);
        int z = crossInv(A, begin, mid, end);
        return x + y + z;
    }

    public int crossInv(int[] A, int begin, int mid, int end) {
        int[] temp = new int[A.length];
        int i = 0, j = mid + 1, cnt = 0, idx = begin;
        while (i <= mid && j <= end) {
            if (A[i] <= A[j]) {
                temp[idx++] = A[i++];
            } else {
                temp[idx++] = A[j++];
                cnt += (mid - i + 1);
            }
        }
        while (i <= mid) {
            temp[idx++] = A[i++];
        }
        while (j <= end) {
            temp[idx++] = A[j++];
        }
        for (int k = begin; k <= end; k++) {
            A[k] = temp[k];
        }
        return cnt;
    }
}
