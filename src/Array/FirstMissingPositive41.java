package Array;

/**
 * @author Vincent
 * @Date 2019-08-15
 */
public class FirstMissingPositive41 {
    public static void main(String[] args) {
        FirstMissingPositive41 fm = new FirstMissingPositive41();
//        System.out.println(fm.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(fm.firstMissingPositive(new int[]{3,4,5,1}));
    }

    /**
     * Idea: The first missing positive number must be in the range 1 <= x <= n + 1, where n is the length of array
     * Why? Consider two edge cases, 1. array is filled all by 0, 2. array is filled with 1 to n
     *
     * Using that property, we can rearrange the array such that nums[i] == nums[nums[i] - 1].
     * The equation above will sort the array into
     * number: 1 2 3 4 5 ...  nums[i]
     * index:  0 1 2 3 4      nums[numsi] - 1]
     * Then we traverse the array, if we find the first element that nums[i] != nums[nums[i] - 1], that means we found
     * the first missing positive number.
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0  && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        int j = 0;
        while (j < nums.length && nums[j] - 1 == j) {
            j++;
        }
        return j + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
