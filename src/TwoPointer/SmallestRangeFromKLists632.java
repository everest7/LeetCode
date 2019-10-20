package TwoPointer;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-18
 */
public class SmallestRangeFromKLists632 {
    public static void main(String[] args) {
        List<List<Integer>> nums = Arrays.asList(Arrays.asList(4,10,15,24,26),Arrays.asList(0,9,12,20), Arrays.asList(5,18,22,30));
        System.out.println(Arrays.toString(smallestRange(nums)));
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        int size = nums.size();
        int[] ptr = new int[size];
        int max = 0, minx = 0, miny = Integer.MAX_VALUE, range = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> nums.get(i).get(ptr[i]) - nums.get(j).get(ptr[j]));
        for (int i = 0; i < nums.size(); i++) {
            pq.add(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            int minIdx = pq.poll();
            if (miny - minx > max - nums.get(minIdx).get(ptr[minIdx])) {
                miny = max;
                minx = nums.get(minIdx).get(ptr[minIdx]);
            }
            ptr[minIdx]++;
            if (ptr[minIdx] >= nums.get(minIdx).size()) {
                break;
            }
            pq.add(minIdx);
            max = Math.max(max, nums.get(minIdx).get(ptr[minIdx]));
        }
        return new int[] {minx, miny};
    }

    //TLE
//    public static int[] smallestRange(List<List<Integer>> nums) {
//        int size = nums.size();
//        int[] ptr = new int[size];
//        int max = 0, min = 0, range = Integer.MAX_VALUE;
//        while (true) {
//            boolean reachEnd = false;
//            int curMin = Integer.MAX_VALUE, curMax = Integer.MIN_VALUE, minIdx = 0;
//            for (int i = 0; i < size; i++) {
//                if (ptr[i] >= nums.get(i).size()) {
//                    reachEnd = true;
//                    break;
//                }
//                if (nums.get(i).get(ptr[i]) < curMin) {
//                    curMin = nums.get(i).get(ptr[i]);
//                    minIdx = i;
//                }
//                if (nums.get(i).get(ptr[i]) > curMax) {
//                    curMax = nums.get(i).get(ptr[i]);
//                }
//            }
//            if (reachEnd) break;
//            if (range > curMax - curMin) {
//                range = curMax - curMin;
//                min = curMin;
//                max = curMax;
//            }
//            ptr[minIdx]++;
//        }
//        return new int[] {min, max};
//    }
}
