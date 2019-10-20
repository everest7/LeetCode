package Array;

public class FindPeakElement162 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        FindPeakElement162 fp = new FindPeakElement162();
        System.out.println(fp.findPeakElement(nums));
    }
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
