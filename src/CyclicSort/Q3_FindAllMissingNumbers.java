package CyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3_FindAllMissingNumbers {
    public static void main(String[] args) {
        List<Integer> missing = solution(new int[] { 2, 3, 1, 8, 2, 3, 1, 1 });
        System.out.println("Missing numbers: " + missing); // [4, 6, 7]

        missing = solution(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing); // [3]

        missing = solution(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing); // [4]
    }

    public static List<Integer> solution(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }

        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
