package BinarySearch;

/**
 * @author Vincent
 * @Date 2019-08-09
 */
public class SplitArrayLargestSum410 {
    public static void main(String[] args) {
        SplitArrayLargestSum410 sa = new SplitArrayLargestSum410();
        System.out.println(sa.split(new int[] {7,2,5,10,8}, 2));
    }

    /**
     * Binary Search
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int pieces = split(nums, mid);
            if (pieces > m) { // means we can narrow down the largestSum
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // See how many pieces we can get with the given largestSum
    public int split(int[] nums, int largestSum) {
        int pieces = 1, tempSum = 0;
        for (int num : nums) {
            if (tempSum + num > largestSum) {
                tempSum = num;
                pieces++;
            } else {
                tempSum += num;
            }
        }
        return pieces;
    }
}
