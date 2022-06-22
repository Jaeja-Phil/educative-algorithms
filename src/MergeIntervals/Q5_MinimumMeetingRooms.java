package MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
};


public class Q5_MinimumMeetingRooms {

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        int result = solution(input);
        System.out.println("Minimum meeting rooms required: " + result); // 2

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        result = solution(input);
        System.out.println("Minimum meeting rooms required: " + result); // 2

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = solution(input);
        System.out.println("Minimum meeting rooms required: " + result); // 1

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = solution(input);
        System.out.println("Minimum meeting rooms required: " + result);// 2
    }

    public static int solution(List<Meeting> meetings) {
        // sort the meetings on start time, ascending
        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        // create a min-heap to store all active meetings
        // use min-heap to find active meeting with smallest end time
        PriorityQueue<Meeting> minHeap =  new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));

        // create variable to store minimum rooms required for each iteration of meetings
        int minRooms = 0;

        // iterate meetings
        for (Meeting meeting : meetings) {
            // while minHeap is not empty, and current meeting (which is sorted by start time)
            // starts after a meeting ends, empty the room
            while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) {
                minHeap.poll();
            }

            // add a meeting room
            minHeap.offer(meeting);
            // compare & update minRoom - whether current operating(?) room size is bigger than recorded minRooms
            minRooms = Math.max(minRooms, minHeap.size());
        }

        // finally return minRoom
        return minRooms;
    }
}
