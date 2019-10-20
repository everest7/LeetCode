package BinarySearch;

/**
 * @author Vincent
 * @Date 2019-05-10
 */
public class SearchRotatedSortedArrayII81 {
    public static void main(String[] args) {
        SearchRotatedSortedArrayII81 sr = new SearchRotatedSortedArrayII81();
        System.out.println(sr.search(new int[]{1, 3}, 3));
    }
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right--;
            }
        }
        return false;
    }
}
