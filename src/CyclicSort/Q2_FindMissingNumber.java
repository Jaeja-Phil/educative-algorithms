package CyclicSort;

import java.util.Arrays;

public class Q2_FindMissingNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { 4, 0, 3, 1 })); // 2
        System.out.println(solution(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 })); // 7
    }

    public static int solution(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
