package Array;

import java.util.Arrays;
import java.util.Map;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater11 cw = new ContainerWithMostWater11();
        System.out.println(cw.maxArea(nums));

    }
    // Brute Force
//    public int maxArea(int[] height) {
//        int res = 0;
//        for (int i = 0; i < height.length; i++){
//            for (int j = 0; j < height.length; j++){
//                res = Math.max(res, Math.min(height[j], height[i]) * (j - i));
//            }
//        }
//        return res;
//    }

    // Two Pointer
    public int maxArea(int[] height){
        int maxArea = 0;
        int low = 0, high = height.length - 1;
        while (low < high){
            maxArea = Math.max(maxArea, Math.min(height[low], height[high]) * (high - low));
            if (height[low] <= height[high]){
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }
}
