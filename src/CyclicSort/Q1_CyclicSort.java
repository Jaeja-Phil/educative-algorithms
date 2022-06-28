package CyclicSort;

import java.util.Arrays;

public class Q1_CyclicSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        solution(arr);
        for (int num : arr)
            System.out.print(num + " "); // [1, 2, 3, 4, 5]
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        solution(arr);
        for (int num : arr)
            System.out.print(num + " "); // [1, 2, 3, 4, 5, 6]
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        solution(arr);
        for (int num : arr)
            System.out.print(num + " "); // [1, 2, 3, 4, 5, 6]
        System.out.println();
    }

    public static void solution(int[] nums) {
        int idx = 0;
        while (idx < nums.length) {
            int targetIdx = nums[idx] - 1;
            // if value at current index is not equal to the value at target index, swap
            // so at least one of the index is in the right place.
            if (nums[idx] != nums[targetIdx]) {
                swap(nums, idx, targetIdx);
            } else {
                idx++;
            }
        }
    }

    private static void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
