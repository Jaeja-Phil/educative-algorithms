package TwoPointers;

import java.util.Arrays;

public class Q6_TripletsWithSmallerSum {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { -1, 0, 2, 3 }, 3)); // 2, [-1, 0, 3] and [-1, 0, 2] gives sum less than 3
        System.out.println(solution(new int[] { -1, 4, 2, 1, 3 }, 5)); // 4, [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3] gives sum less than 5
    }

    public static int solution(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target - arr[i], i + 1);
        }

        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int left) {
        int count = 0;
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum < targetSum) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
