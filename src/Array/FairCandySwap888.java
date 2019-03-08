package Array;

import java.util.Arrays;
import java.util.HashSet;

public class FairCandySwap888 {
    public static void main(String[] args) {
        FairCandySwap888 fc = new FairCandySwap888();
        int[] nums1 = {1,2,5};
        int[] nums2 = {2,4};
        System.out.println(Arrays.toString(fc.fairCandySwap(nums1,nums2)));
    }
    // Using HashSet to determine whether it has a specified object
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int sum1 = 0, sum2 = 0;
        HashSet<Integer> setA = new HashSet<>();
        for (int num : A){
            sum1 += num;
            setA.add(num);
        }
        for (int num : B){
            sum2 += num;
        }
        int diff = (sum1 - sum2) / 2;
        for (int num : B){
            int targetA = num + diff;
            if (setA.contains(targetA)) return new int[] {targetA,num};
        }

        return null;

    }
}
