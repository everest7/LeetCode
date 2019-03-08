package Array;

/**
 * @Author Vincent
 * @Date
 * @Review 2019-3-7
 */
public class PeakIndexArray852 {
    public static void main(String[] args) {
        PeakIndexArray852 pa = new PeakIndexArray852();
        int[] nums = {0, 2, 1, 4, 3, 1, 0};
        int[] nums2 = {0, 1, 0};
        System.out.println(pa.peakIndexInMountainArray(nums2));
    }

    // Simple Solution
    public int peakIndexInMountainArray(int[] A) {
        if (A.length == 1 || A == null) return 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[i + 1]) return i;
        }
        return 0;
    }
    /**
     * Binary Search
     */

//    public int peakIndexInMountainArray(int[] A) {
//        int left = 0, right = A.length - 1;
//
//        while(left < right){
//            int mid = left + (right - left) / 2;
//            if (A[mid] < A[mid - 1]){
//                right = mid;
//            }
//            else if (A[mid] < A[mid + 1]){
//                left = mid;
//            }
//            else return mid;
//
//        }
//        return 0;
//    }
}
