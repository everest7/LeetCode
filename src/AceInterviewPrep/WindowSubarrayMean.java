package AceInterviewPrep;

/**
 * @author Vincent
 * @Date 2019-08-02
 */

import java.util.*;

/**
 * 1.给一个int数组，和一个窗口长度，求等于这个窗口长度的所有subarray的平均值，
 * 要求保留两位小数并且cast到string，最后返回一个string数组。
 * 例子：[1,1,1,1,1,1,1,7] 和 窗口长度 7 => 返回 ["1.00","1.86"]
 */
public class WindowSubarrayMean {
    public static void main(String[] args) {
        WindowSubarrayMean ws = new WindowSubarrayMean();
        System.out.println(ws.subarrayMean(new int[] {1,1,1,1,1,1,1,7}, 7));
    }

    public List<String> subarrayMean(int[] nums, int k) {
        int sum = 0, left = 0, right = 0;
        List<String> res = new ArrayList<>();
        while (right < nums.length) {
            sum += nums[right++];
            if (right - left == 7) {
                double ans = (double) sum / k;
                res.add(String.format("%.2f", ans));
            }
            while (right - left + 1 > k) {
                sum -= nums[left];
                left++;
            }
        }
        return res;
    }
}
