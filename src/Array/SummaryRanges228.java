package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent
 * @Date 2019-06-13
 */
public class SummaryRanges228 {
    public static void main(String[] args) {
        SummaryRanges228 sr = new SummaryRanges228();
        System.out.println(sr.summaryRanges(new int[] {0,2,3,4,6,8,9}));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0, n = nums.length;
        while (i < n) {
            int j = 1;
            while (i + j < n && nums[i + j] - nums[i] == j) {
                j++;
            }
            if (j == 1) {
                res.add(Integer.toString(nums[i]));
            } else {
                res.add(nums[i] + "->" + (nums[i + j - 1]));
            }
            i += j;
        }
        return res;
    }
}
