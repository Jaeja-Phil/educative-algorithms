package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2_InsertInterval {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : solution(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] "); // [[1, 3], [4, 7], [8, 12]]
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : solution(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] "); // [[1, 3], [4, 12]]
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : solution(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] "); // [[1, 4], [5, 7]]
        System.out.println();
    }

    public static List<Interval> solution(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty()) {
            return Arrays.asList(newInterval);
        }

        List<Interval> mergedIntervals = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        mergedIntervals.add(newInterval);

        while (i < intervals.size()) {
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        return mergedIntervals;
    }
}
