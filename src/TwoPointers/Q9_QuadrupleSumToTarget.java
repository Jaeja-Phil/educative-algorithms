package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q9_QuadrupleSumToTarget {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { 4, 1, 2, -1, 1, -3 }, 1)); // [[-3, -1, 1, 4], [-3, 1, 1, 2]]
        System.out.println(solution(new int[] { 2, 0, -1, 1, -2, 2 }, 2)); // [[-2, 0, 2, 2], [-1, 0, 1, 2]]
    }

    public static List<List<Integer>> solution(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }
                addPairs(ans, arr, i, j, target);
            }
        }

        return ans;
    }

    public static void addPairs(List<List<Integer>> ans, int[] arr, int first, int second, int target) {
        int left = second + 1;
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[first] + arr[second] + arr[left] + arr[right];
            if (currentSum == target) {
                ans.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }
                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
