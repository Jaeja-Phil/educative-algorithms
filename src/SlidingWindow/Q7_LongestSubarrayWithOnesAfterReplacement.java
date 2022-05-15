package SlidingWindow;

public class Q7_LongestSubarrayWithOnesAfterReplacement {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(solution(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }

    public static int solution(int[] arr, int k) {
        int maxOnesCount = 0;
        int left = 0, maxLen = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 1) {
                maxOnesCount++;
            }

            if (right - left + 1 - maxOnesCount > k) {
                if (arr[left] == 1) {
                    maxOnesCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
