package DynamicProgramming;
import java.util.*;
/**
 * @author Vincent
 * @Date 10/19/19
 */
public class MaximumProfitJobScheduling {
    public static void main(String[] args) {
        System.out.println(jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70}));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[profit.length][3];
        for (int i = 0; i < profit.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int n = profit.length;
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            int include = jobs[i][2];
            int l = binarySearch(jobs, i);
            if (l != -1) {
                include += dp[l];
            }
            dp[i] = Math.max(include, dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static int binarySearch(int[][] jobs, int index) {
        int left = 0, right = index - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] <= jobs[index][0]) {
                if (jobs[mid + 1][1] <= jobs[index][0]) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
