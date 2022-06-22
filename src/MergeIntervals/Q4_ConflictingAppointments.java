package MergeIntervals;

import java.util.Arrays;

public class Q4_ConflictingAppointments {
    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = solution(intervals);
        System.out.println("Can attend all appointments: " + result); // false

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = solution(intervals1);
        System.out.println("Can attend all appointments: " + result); // true

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = solution(intervals2);
        System.out.println("Can attend all appointments: " + result); // false
    }

    public static boolean solution(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }

        return true;
    }
}
