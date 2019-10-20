package Greedy;

/**
 * @author Vincent
 * @Date 2019-08-14
 */
public class JumpGameII45 {
    public static void main(String[] args) {
//        System.out.println(jump(new int[] {2,3,1,1,4}));
        System.out.println(jump(new int[] {3,2,1}));
    }

    public static int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int curMax = 0, level = 0, i = 0;
        while (i <= curMax) {
            int furthest = curMax;
            level++;
            for (; i <= curMax; i++) {
                furthest = Math.max(furthest, nums[i] + i);
                if (furthest >= nums.length - 1) return level;
            }
            curMax = furthest;
        }
        return -1;
    }
}
