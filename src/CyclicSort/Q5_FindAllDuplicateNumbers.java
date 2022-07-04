package CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class Q5_FindAllDuplicateNumbers {
    public static void main(String[] args) {
        List<Integer> duplicates = solution(new int[] { 3, 4, 4, 5, 5 });
        System.out.println("Duplicates are: " + duplicates); // [4, 5]

        duplicates = solution(new int[] { 5, 4, 7, 2, 3, 5, 3 });
        System.out.println("Duplicates are: " + duplicates); // [3, 5]
    }

    public static List<Integer> solution(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(nums[i]);
            }
        }

        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
