package TwoPointers;

import java.util.Arrays;

public class Q5_TripletSumCloseToTarget {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { -2, 0, 1, 2 }, 2)); // 1, [-2, 1, 2] has closest sum to target
        System.out.println(solution(new int[] { -3, -1, 1, 2 }, 1)); // 0, [-3, 1, 2] has closest sum to target
        System.out.println(solution(new int[] { 1, 0, 1, 1 }, 100)); // 3, [1, 1, 1] has closest sum to target
    }

    public static int solution(int[] arr, int targetSum) {
        int smallestDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
                if (targetDiff == 0) {
                    return targetSum;
                }

                if (Math.abs(targetDiff) < Math.abs(smallestDiff) ||
                        Math.abs(targetDiff) == Math.abs(smallestDiff) && targetDiff > smallestDiff) {
                    smallestDiff = targetDiff;
                }

                if (targetDiff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return targetSum - smallestDiff;
    }
}
