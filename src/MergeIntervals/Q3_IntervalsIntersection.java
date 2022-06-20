package MergeIntervals;

import java.util.*;

public class Q3_IntervalsIntersection {
    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = solution(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] "); // [[2, 3], [5, 6], [7, 7]]
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = solution(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] "); // [[5, 7], [9, 10]]
    }

    public static Interval[] solution(Interval[] arr1, Interval[] arr2) {
        List<Interval> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (
                    (arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end) ||
                            (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)
            ) {
                result.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
            }

            if (arr1[i].end < arr2[j].end) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new Interval[result.size()]);
    }
}
