package Greedy;

import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Vincent
 * @Date 2019-07-15
 */
public class MeetingRoomsII253 {
    public static void main(String[] args) {
//        int[][] intervals = new int[][] {{0,30},{5,10},{15,20},{25,40}};
//        int[][] intervals = new int[][] {{0,30},{4,9},{4,17}};
//        int[][] intervals = new int[][] {{9,14},{5,6},{3,5},{12,19}};
        int[][] intervals = new int[][] {{8,10},{6,8},{12,14}};

        MeetingRoomsII253 mr = new MeetingRoomsII253();
        System.out.println(mr.minMeetingRoomsFollowup(intervals));
    }
    /**
     * Follow up
     */
    public int minMeetingRoomsFollowup(int[][] intervals) {
//        if (intervals.length == 0) return 0;
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            public int compare(int[] a, int[] b) {
//                if (a[0] < b[0]) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//        });
//        int res = 0;
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(intervals[0][1]);
//        for (int i = 1; i < intervals.length; i++) {
//            if (intervals[i][0] > pq.peek()) {
//                pq.poll();
//                pq.add(intervals[i][1]);
//            } else {
//                pq.add(intervals[i][1]);
//            }
//            res = Math.max(res, pq.size() * pq.peek());
//        }
//        return res;

        int res = 0, max = 0;
        int result = 0;
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        Set<Integer> list = new TreeSet<>();
        for (int[] interval: intervals) {
            start.put(interval[0], start.getOrDefault(interval[0], 0) + 1);
            end.put(interval[1], end.getOrDefault(interval[1], 0) + 1);
            list.add(interval[0]);
            list.add(interval[1]);
        }
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()){
            int num = itr.next();
            if (start.containsKey(num)) {
                res += start.get(num);
            }
            result = Math.max(result, max * num);
            if (end.containsKey(num)) {
                res -= end.get(num);
            }
            max = Math.max(Math.max(res, 0), max);
        }
        return result;
    }

    /**
     * Sort starting and ending time respectively.
     * If current starting time is smaller than ending position's time, meaning we need more room.
     * i.e find intersection of the interval
     * @param intervals
     * @return
     */
//    public int minMeetingRooms(int[][] intervals) {
//        int n = intervals.length;
//        int[] start = new int[n];
//        int[] end = new int[n];
//        for (int i = 0; i < n; i++) {
//            start[i] = intervals[i][0];
//            end[i] = intervals[i][1];
//        }
//        Arrays.sort(start);
//        Arrays.sort(end);
//        int room = 0, endIdx = 0;
//        for (int i = 0; i < n; i++) {
//            if (start[i] < end[endIdx]) {
//                room++;
//            } else {
//                endIdx++;
//            }
//        }
//        return room;
//    }

    /**
     * Scanning line
     */
//    public int minMeetingRooms(int[][] intervals) {
//        int res = 0, max = 0;
//        Map<Integer, Integer> start = new HashMap<>();
//        Map<Integer, Integer> end = new HashMap<>();
//        Set<Integer> list = new TreeSet<>();
//        for (int[] interval: intervals) {
//            start.put(interval[0], start.getOrDefault(interval[0], 0) + 1);
//            end.put(interval[1], end.getOrDefault(interval[1], 0) + 1);
//            list.add(interval[0]);
//            list.add(interval[1]);
//        }
//        Iterator<Integer> itr = list.iterator();
//        while (itr.hasNext()){
//            int num = itr.next();
//            if (start.containsKey(num)) {
//                res += start.get(num);
//            }
//            if (end.containsKey(num)) {
//                res -= end.get(num);
//            }
//            max = Math.max(Math.max(res, 0), max);
//        }
//        return max;
//
//    }

    /**
     * Sorting + PriorityQueue
     * Sort the intervals according to their starting time.
     * Using priority queue(MinHeap) to store the end time of intervals
     * Loop through the intervals,
     * if the current starting time is before the first ending time is pq,
     * that means we have a conflict, adding the current ending time to the pq.
     * else, we poll the first ending time in pq, since that room is available again.
     * @param intervals
     * @return
     */
//    public int minMeetingRooms(int[][] intervals) {
//        if (intervals.length == 0) return 0;
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            public int compare(int[] a, int[] b) {
//                if (a[0] < b[0]) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//        });
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(intervals[0][1]);
//        for (int i = 1; i < intervals.length; i++) {
//            if (intervals[i][0] >= pq.peek()) {
//                pq.poll();
//                pq.add(intervals[i][1]);
//            } else {
//                pq.add(intervals[i][1]);
//            }
//        }
//        return pq.size();
//    }
}
