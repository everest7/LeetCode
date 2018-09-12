package Math;

public class MinMovesToEqual453 {
    public static void main(String[] args) {
        MinMovesToEqual453 ms = new MinMovesToEqual453();
        int[] nums = {1,2,3};
        System.out.println(ms.minMoves(nums));
    }
    public int minMoves(int[] nums) {
        int sum = 0, min = nums[0];
        for (int i = 0; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }
        return sum - min * nums.length;
    }
}
