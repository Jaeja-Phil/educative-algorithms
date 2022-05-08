package SlidingWindow;

public class Q1_MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + solution(3, new int[] {2, 1, 5, 1, 3, 2}));
        // answer: 9, sum of 5 + 1 + 3 will produce the max sum

        System.out.println("Maximum sum of a subarray of size K: "
                + solution(2, new int[] {2, 3, 4, 1, 5}));
        // answer: 7, sum of 3 + 4 will produce the max sum
    }

    public static int solution(int k, int[] arr) {
        // create 2 variables to keep track of the max sum, and current sum (window sum)
        int maxSum = 0, windowSum = 0;
        // the left side of the sliding window
        int left = 0;
        // initialize right side of the window as 0,
        // start increasing the right
        for (int right = 0; right < arr.length; right++) {
            // add current "right" end value of the window to windowSum
            windowSum += arr[right];
            // if the size of right is equal or greater than k - 1 (# of contiguous elements has been fulfilled)
            // compare the maxSum with current windowSum and replace whichever is bigger
            // slide the window
            // - subtract the "left" value of the window
            // - increase left by one
            if (right >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[left];
                left++;
            }
        }

        // return the maximum so far
        return maxSum;
    }
}
