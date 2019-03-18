package DynamicProgramming;

public class HouseRobber198 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1,5};
        int[] nums2 = {1};
        HouseRobber198 hr = new HouseRobber198();
        System.out.println(hr.rob(nums));
        System.out.println(hr.rob(nums2));
    }

    public int rob(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        int[] f = new int[nums.length];
        f[0] = nums[0];
        f[1] = Math.max(f[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);
        }
        return f[nums.length - 1];
    }
}
