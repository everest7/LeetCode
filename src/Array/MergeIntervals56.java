package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval{
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals56 {
    public static void main(String[] args) {
        Interval in1 = new Interval(0, 4);
        Interval in2 = new Interval(1, 5);
        Interval in3 = new Interval(8, 10);
        Interval in4 = new Interval(15, 18);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);
        MergeIntervals56 mi = new MergeIntervals56();
        for (Interval in: mi.merge(intervals)){
            System.out.println(in.start + " " + in.end);
        }


    }
    public List<Interval> merge(List<Interval> intervals){
        if (intervals.size() <= 1) return intervals;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals){
            if (interval.start <= end){
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }


//    public List<Interval> merge(List<Interval> intervals) {
//        Collections.sort(intervals, (a, b) -> a.start - b.start);
//        List<Interval> res = new ArrayList<Interval>();
//        for(int i = 0; i < intervals.size(); i++ ){
//            int j = i;
//            while (j < intervals.size() - 1 && intervals.get(j).end >= intervals.get(j + 1).start){
//                j++;
//            }
//            Interval inter;
//            if (i != j){
//                inter = new Interval(intervals.get(i).start, intervals.get(j).end);
//                i = j;
//            } else {
//                inter = new Interval(intervals.get(i).start, intervals.get(i).end);
//            }
//            res.add(inter);
//
//        }
//        return res;
//    }
}
