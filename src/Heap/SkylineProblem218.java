package Heap;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-22
 */
public class SkylineProblem218 {
    public static void main(String[] args) {
        int[][] buildings = new int[][]{{2,9,10},{3,7,15},{5,12,12}};
        System.out.println(getSkyline(buildings));
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] building: buildings) {
            heights.add(new int[] {building[0], building[2]}); // s
            heights.add(new int[] {building[1], -building[2]});
        }
        // Now heights contains all start and end point of buildings in ascending order
        Collections.sort(heights, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        // PQ stores all the encountered buildings' heights in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.add(0);
        int prev = 0, cur = 0;
        for (int[] h : heights) {
            if (h[1] > 0) {
                pq.add(h[1]); // encounter a new building, add it to the queue
            } else {
                pq.remove(-h[1]); // reached the end of building, remove it from the queue
            }
            // if the max height is different from the previous one, that means a critical point is met, add to result list
            cur = pq.peek();
            if (prev != cur) {
                res.add(Arrays.asList(h[0], cur));
                prev = cur;
            }
        }
        return res;
    }
}
