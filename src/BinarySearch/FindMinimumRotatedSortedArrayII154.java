package BinarySearch;

/**
 * @author Vincent
 * @Date 2019-08-30
 */
public class FindMinimumRotatedSortedArrayII154 {
    public static void main(String[] args) {
//        System.out.println(findMin(new int[] {1,3,3}));
        System.out.println(findMin(new int[] {3,3,1,3}));
    }

    /**
     * Since there are duplicates in the array, binary search cannot be implemented directly
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            } else { // nums[mid] == nums[right], we encounter the duplicate, decrement the right pointer
                right--;
            }
        }
        return nums[left];
    }
}
