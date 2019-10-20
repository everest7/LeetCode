package BinarySearch;

/**
 * @author Vincent
 * @Date 2019-08-30
 */
public class SearchinRotatedSortedArray {
    public static void main(String[] args) {

//        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 0));
        System.out.println(search(new int[] {1, 3}, 3));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // [] therefore it's left <= right, both sides inclusive
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] <= nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
