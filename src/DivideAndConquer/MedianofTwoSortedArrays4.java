package DivideAndConquer;

public class MedianofTwoSortedArrays4 {
    public static void main(String[] args) {
        int[] nums1 = {4};
        int[] nums2 = {1,2, 3,5,6,7};
        MedianofTwoSortedArrays4 mt = new MedianofTwoSortedArrays4();
        System.out.println(mt.findMedianSortedArrays(nums1, nums2));

    }

    /**
     * len = nums.length + nums.length
     * If len is an even number, then the median of two array is the sum of (len/2)th and (len/2 + 1)th number / 2
     * If len is an odd number, then the median of two array is (len/2 + 1)th number
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 0) {
            return (findKth(nums1, nums2, 0, 0, n / 2) + findKth(nums1, nums2, 0, 0,  n / 2 + 1)) / 2;
        }
        return findKth(nums1, nums2, 0, 0, n / 2 + 1);
    }

    public double findKth(int[] nums1, int[] nums2, int startA, int startB, int k) {
//        if (startA >= nums1.length) return nums2[startB + (k - 1) / 2];
//        if (startB >= nums2.length) return nums1[startA + (k - 1) / 2];
//        if (k == 1) {
//            return (double)Math.min(nums1[startA], nums2[startB]);
//        }
//        int left = startA + k / 2 - 1 < nums1.length ? nums1[startA + k / 2 - 1] : Integer.MAX_VALUE;
//        int right = startB + k / 2 - 1 < nums2.length ? nums2[startB + k / 2 - 1] : Integer.MAX_VALUE;
//        if (left < right) {
//            return findKth(nums1, nums2, startA + k / 2, startB,  k - k / 2);
//        } else {
//            return findKth(nums1, nums2, startA, startB + k / 2,  k - k / 2);
//        }
        if (startA >= nums1.length) return nums2[startB + k - 1];
        if (startB >= nums2.length) return nums1[startA + k - 1];
        if (k == 1) {
            return (double)Math.min(nums1[startA], nums2[startB]);
        }
        int left = startA + k / 2 - 1 < nums1.length ? nums1[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int right = startB + k / 2 - 1 < nums2.length ? nums2[startB + k / 2 - 1] : Integer.MAX_VALUE;
        if (left < right) {
            return findKth(nums1, nums2, startA + k / 2, startB,  k - k / 2);
        } else {
            return findKth(nums1, nums2, startA, startB + k / 2,  k - k / 2);
        }

    }












//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//        int[] arr = new int[len1 + len2];
//        int i = 0, j = 0, index = 0;
//        while (i < len1 && j < len2){
//            if (nums1[i] <= nums2[j]){
//                arr[index++] = nums1[i++];
//            } else {
//                arr[index++] = nums1[j++];
//            }
//        }
//        if ((len1 + len2) % 2 == 0){
//            return (arr[(len1 + len2) / 2] + arr[(len1 + len2) / 2 - 1]) / 2.0;
//        } else {
//            return arr[(len1 + len2) / 2];
//        }
//    }
}
