package BinarySearch;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-05-13
 */
public class FindRightInterval436 {
    public static void main(String[] args) {
        FindRightInterval436 fr = new FindRightInterval436();
        System.out.println(Arrays.toString(fr.findRightInterval(new int[][]{{1,4},{2,3},{3,4}})));
    }

    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        Map<Integer, Integer> map = new
                HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
            list.add(intervals[i][0]);
        }
        Collections.sort(list);
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int start = binarySearch(list, end);
            if (start < end) {
                res[i] = -1;
            } else {
                // as long as there exist at least one start >= end, it'll suffice
                res[i] = map.get(start);
            }
        }
        return res;
    }
    public int binarySearch(List<Integer> list, int x) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return list.get(left);
    }
}
