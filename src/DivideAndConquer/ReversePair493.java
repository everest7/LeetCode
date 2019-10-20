package DivideAndConquer;

/**
 * @author Vincent
 * @Date 2019-05-21
 */
public class ReversePair493 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,2,3,1};
        ReversePair493 rp = new ReversePair493();
        System.out.println(rp.reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }
    public int mergeSort(int[] nums, int begin, int end) {
        if (begin >= end) return 0;
        int mid = (begin + end) / 2;
        int left = mergeSort(nums, begin, mid);
        int right = mergeSort(nums, mid + 1, end);
        int cross = merge(nums, begin, mid, end);
        return left + right + cross;
    }
    public int merge(int[] nums, int start, int mid, int end) {
        int n1 = (mid - start + 1);
        int n2 = (end - mid);
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = nums[start + i];
        for (int j = 0; j < n2; j++)
            R[j] = nums[mid + 1 + j];
        int i = 0, j = 0;
        for (int k = start; k <= end; k++) {
            if (j >= n2 || (i < n1 && L[i] <= R[j]))
                nums[k] = L[i++];
            else
                nums[k] = R[j++];
        }
//        int[] temp = new int[nums.length];
//        int i = begin, j = mid + 1, cnt = 0, idx = begin;
//        while (i <= mid && j <= end) {
//            if (nums[i] <= 2 * nums[j]) {
//                temp[idx++] = nums[i++];
//            } else {
//                temp[idx++] = nums[j++];
//                cnt += (mid - i + 1);
//            }
//        }
//        while (i <= mid) {
//            temp[idx++] = nums[i++];
//        }
//        while (j <= end) {
//            temp[idx++] = nums[j++];
//        }
//        for (int k = begin; k <= end; k++) {
//            nums[k] = temp[k];
//        }
//        return cnt;
        return 0;
    }
}
