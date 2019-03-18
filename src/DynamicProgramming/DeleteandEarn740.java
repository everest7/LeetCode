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

    /**
     * Reduce to House Robber Problem.
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        for (int x : nums) {
            arr[x] += x;
        }
        int pre = 0;
        int cur = 0;
        for (int x : arr) {
            int temp = cur;
            cur = Math.max(cur, pre + x);
            pre = temp;
        }
        return cur;
    }
}
