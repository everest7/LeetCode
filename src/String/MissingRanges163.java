package String;
import java.util.*;
/**
 * @author Vincent
 * @Date 9/30/19
 */
public class MissingRanges163 {
    public static void main(String[] args) {
        System.out.println(findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0,99));
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            if (lower == upper) return Arrays.asList(lower + "");
            if (upper > lower) return Arrays.asList(lower + "->" + upper);
        }
        List<String> res = new ArrayList<>();
        long left = (long) lower;
        long up = (long) upper;
        for (int i = 0; i <= nums.length; i++) {
            long right = (i < nums.length && nums[i] <= up) ? nums[i] : up + 1;
            if (left == right) left++;
            else if (right > left) {
                res.add(right - left > 1 ? left + "->" + (right - 1) : left + "");
                left = right + 1;
            }
        }
        return res;
    }
}
