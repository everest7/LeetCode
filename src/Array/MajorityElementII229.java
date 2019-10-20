package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent
 * @Date 2019-07-20
 */
public class MajorityElementII229 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,3,3,2,2,2};
        MajorityElementII229 me = new MajorityElementII229();
        System.out.println(me.majorityElement(nums));
    }

    /**
     * Boyer-Moore Voting Algorithm
     *
     * Idea: An array of size n can have at most 2 elements that appear more than n/3 time.
     * Therefore we keep two candidate a, b and their counter cnt1 and cnt2.
     * Whenever we encounter a, cnt1++, otherwise cnt--. When cnt1 == 0, we starting looking for new candidate for a.
     * Same applies to b.
     * After the first iteration, we will end up with two most dominant element a and b.
     * Using the second iteration to check if their frequencies is greater than n/3.
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        int a = 0, b = 0, cnt1 = 0, cnt2 = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (a == nums[i]) cnt1++;
            else if (b == nums[i]) cnt2++;
            else if (cnt1 == 0) {a = nums[i]; cnt1 = 1;}
            else if (cnt2 == 0) {b = nums[i]; cnt2 = 1;}
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (a == num) cnt1++;
            else if (b == num) cnt2++;
        }
        List<Integer> res = new ArrayList<>();
        if (cnt1 > len / 3) res.add(a);
        if (cnt2 > len / 3) res.add(b);
        return res;
    }
}
