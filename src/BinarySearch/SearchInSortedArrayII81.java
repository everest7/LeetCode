package BinarySearch;

/**
 * @author Vincent
 * @Date 2019-05-20
 */
public class SearchInSortedArrayII81 {
    public static void main(String[] args) {
        SearchInSortedArrayII81 ss = new SearchInSortedArrayII81();
//        System.out.println(ss.search(new int[] {2, 5}, 5));
        System.out.println(ss.search(new int[] {1,1,3,1}, 3));
    }

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < nums[right]) {
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
                right--; // in this case, we are not sure which half to discard, but we can discard the right index
            }
        }
        return false;
    }
}
