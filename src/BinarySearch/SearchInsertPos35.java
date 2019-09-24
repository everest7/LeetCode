package BinarySearch;

public class SearchInsertPos35 {
    public static void main(String[] args) {
        SearchInsertPos35 si = new SearchInsertPos35();
        int[] nums1 = {1,3,5,6};
        System.out.println(si.searchInsert(nums1,7));
    }

    /**
     * while (left <= right), we should use <= here, since when left == right, that means the target does not exist in
     * the array, we need to insert after the [left]
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;

        }
        return left;
    }


}
