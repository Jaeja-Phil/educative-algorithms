package MergeIntervals;

import java.util.*;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

public class Q6_MaxCpuLoad {
    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6))); // 7
        System.out.println("Maximum CPU load at any time: " + solution(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15))); // 15
        System.out.println("Maximum CPU load at any time: " + solution(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5))); // 8
        System.out.println("Maximum CPU load at any time: " + solution(input));
    }

    public static int solution(List<Job> jobs) {
        if (jobs.size() < 1) return 0;

        Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));
        int maxCpuLoad = 0;
        int currentCpuLoad = 0;
        for (Job job : jobs) {
            while (!minHeap.isEmpty() && job.start > minHeap.peek().end) {
                currentCpuLoad -= minHeap.poll().cpuLoad;
            }
            minHeap.offer(job);
            currentCpuLoad += job.cpuLoad;
            maxCpuLoad = Math.max(maxCpuLoad, currentCpuLoad);
        }

        return maxCpuLoad;
    }
}
