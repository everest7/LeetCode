package DynamicProgramming;
import java.util.*;
/**
 * @author Vincent
 * @Date 10/9/19
 */
public class MaximumSum3NonOverlappingSubarrays689 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTriplet(new int[] {1,2,1,2,6,7,5,1}, 2)));
    }

    public static int[] findTriplet(int[] nums, int k) {
        int[] res = new int[3];
        int[] prefix = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i - k + 1 >= 0) {
                prefix[i - k + 1] = sum;
            }
        }
        int[] leftMax = new int[prefix.length];
        int leftIdx = 0;
        for (int i = 0; i < prefix.length; i++) {
            if (prefix[i] > prefix[leftIdx]) {
                leftIdx = i;
            }
            leftMax[i] = leftIdx;
        }
        int[] rightMax = new int[prefix.length];
        int rightIdx = prefix.length - 1;
        for (int i = prefix.length - 1; i >= 0; i--) {
            if (prefix[i] >= prefix[rightIdx]) {
                rightIdx = i;
            }
            rightMax[i] = rightIdx;
        }
        Arrays.fill(res, -1) ;
        for (int i = k; i < prefix.length - k; i++) {
            if (res[0] == -1 || prefix[res[0]] + prefix[res[1]] + prefix[res[2]] <
                    prefix[leftMax[i - k]] + prefix[i] + prefix[rightMax[i + k]]) {
                res[0] = leftMax[i - k];
                res[1] = i;
                res[2] = rightMax[i + k];
            }
        }
        return res;
    }
}
