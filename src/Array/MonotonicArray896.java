package Array;

public class MonotonicArray896 {
    public static void main(String[] args) {
        MonotonicArray896 ma = new MonotonicArray896();
        int[] nums1 = {1,2,2,4};
        int[] nums2 = {1,1,1};
        int[] nums3 = {4,3,2,2};
        System.out.println(ma.isMonotonic(nums1));
        System.out.println(ma.isMonotonic(nums2));
        System.out.println(ma.isMonotonic(nums3));


    }

    public boolean isMonotonic(int[] A) {
        boolean increase = true;
        boolean decrease = true;
        for (int i = 0; i < A.length - 1; i++){
            if(A[i] < A[i+1]){
                decrease = false;
            } else if(A[i] > A[i+1]) {
                increase = false;
            }
        }

        return increase || decrease;
    }
}
