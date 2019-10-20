package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Vincent
 * @Date 2019-07-12
 */
public class MeetingRooms252 {
    public static void main(String[] args) {
//        int[][] intervals = new int[][] {{0,30},{5,10},{15,20}};
        int[][] intervals = new int[][] {{7,10},{2,4}};
        MeetingRooms252 mr = new MeetingRooms252();
        System.out.println(mr.canAttendMeetings(intervals));
    }
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) return false;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                return false;
            }
            start = intervals[i][0];
            end = intervals[i][1];
        }
        return true;

    }
}
