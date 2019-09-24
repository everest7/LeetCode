package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-03-09
 */
public class DeleteandEarn740 {
    public static void main(String[] args) {
        DeleteandEarn740 de = new DeleteandEarn740();
        System.out.println(de.deleteAndEarn(new int[]{3,4,2}));
    }

    public int deleteAndEarn(int[] nums) {
        int[] range = new int[10001];
        for (int num : nums) {
            range[num] += num;
        }
        int[] dp = new int[10001];
        dp[0] = range[0];
        dp[1] = Math.max(range[0], range[1]);
        for (int i = 2; i < 10001; i++) {
            dp[i] = Math.max(dp[i - 2] + range[i], dp[i - 1]);
        }
        return dp[10000];
    }

    /**
     * Reduce to House Robber Problem.
     * @param nums
     * @return
     */
//    public int deleteAndEarn(int[] nums) {
//        int[] arr = new int[10001];
//        for (int x : nums) {
//            arr[x] += x;
//        }
//        int pre = 0;
//        int cur = 0;
//        for (int x : arr) {
//            int temp = cur;
//            cur = Math.max(cur, pre + x);
//            pre = temp;
//        }
//        return cur;
//    }
}
