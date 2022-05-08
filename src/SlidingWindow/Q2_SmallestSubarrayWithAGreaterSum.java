package SlidingWindow;

public class Q2_SmallestSubarrayWithAGreaterSum {
    public static void main(String[] args) {
        int result = solution(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        // result: 2, [5, 2] will produce smallest subarray that is greater or equal to 7

        result = solution(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        // result: 1, [8] will produce smallest subarray that is greater or equal to 7

        result = solution(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
        // result: 3, [3, 4, 1] or [1, 1, 6] will produce smallest subarray that is greater or equal to 8
    }

    public static int solution(int S, int[] arr) {
        // initialize 3 variables
        // - windowSum: to keep track of the sum of current window
        // - minLen: to keep track of the minimum subarray length while iterating through the array
        // - left: "left" side of the window
        int windowSum = 0, minLen = Integer.MAX_VALUE, left = 0;

        // iterate by extending right (the "right" side of the window)
        for (int right = 0; right < arr.length; right++) {
            // add right side value of the window to current sum (windowSum)
            windowSum += arr[right];
            // once windowSum reach the target value (S),
            // compare and replace minLen with current window size (if current window size is smaller)
            // slide the left side of the window by 1
            // do this until the current sum of the window if less than target value
            while (windowSum >= S) {
                minLen = Math.min(minLen, right - left + 1);
                windowSum -= arr[left];
                left++;
            }
        }

        // finally, return the minimum length that has been kept track of
        return minLen;
    }
}
