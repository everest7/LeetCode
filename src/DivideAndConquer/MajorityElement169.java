package DivideAndConquer;

public class MajorityElement169 {
    public static void main(String[] args) {
        int[] nums = {6,5,5};
        MajorityElement169 me = new MajorityElement169();
        System.out.println(me.majorityElement(nums));
    }

//    public int majorityElement(int[] nums) {
//        return divideConquer(nums, 0, nums.length - 1);
//
//
//    }
    public int divideConquer(int[] nums, int low, int high){
        if (low == high){
            return nums[low];
        }
        int mid = low + (high - low) / 2;
//        int mid = (low + high) / 2;
        int left = divideConquer(nums, low, mid);
        int right = divideConquer(nums, mid + 1, high);
        if (left == right){
            return left;
        }
        int leftCount = count(nums, low, high, left);
        int rightCount = count(nums, low, high, right);
        return leftCount > rightCount ? left : right;

    }
    public int count(int[] nums, int left, int right, int num){
        int res = 0;
        for (int i = left; i <= right; i++){
            if (nums[i] == num){
                res++;
            }
        }
        return res;
    }
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }
}
