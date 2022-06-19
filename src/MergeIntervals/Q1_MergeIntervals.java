package MergeIntervals;

import java.util.*;

public class Q1_MergeIntervals {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : solution(input))
            System.out.print("[" + interval.start + "," + interval.end + "] "); // [[1, 5], [7, 9]]
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : solution(input))
            System.out.print("[" + interval.start + "," + interval.end + "] "); // [[2, 4], [5, 9]]
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : solution(input))
            System.out.print("[" + interval.start + "," + interval.end + "] "); // [[1, 6]]
        System.out.println();
    }

    public static List<Interval> solution(List<Interval> intervals) {
        // sort the interval on start time
        // if interval1 overlaps interval2, merge them into a new interval c such that
        // - c.start = a.start
        // - c.end = max(a.end, b.end)
        if (intervals.size() < 2) {
            return intervals;
        }

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start, end = interval.end;

        while (intervalItr.hasNext()) {
            interval = intervalItr.next();
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }
}
