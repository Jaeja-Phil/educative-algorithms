package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q4_TripletSumToZero {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { -3, 0, 1, 2, -1, 1, -2 })); // [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]
        System.out.println(solution(new int[] { -5, 2, -1, -2, 3 })); // [[-5, 2, 3], [-2, -1, 3]]
    }

    public static List<List<Integer>> solution(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            searchPair(arr, ans, -arr[i], i + 1);
        }

        return ans;
    }

    public static void searchPair(int[] arr, List<List<Integer>> ans, int targetSum, int left) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                ans.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
            } else if (targetSum > currentSum) {
                left++;
            } else {
                right--;
            }
        }
    }
}
