package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class Q1_PairWithTargetSum {
    public static void main(String[] args) {
        int[] result = solution(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]"); // [1, 3]
        result = solution(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]"); // [0, 2]
    }

    public static int[] solution(int[] arr, int targetSum) {
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i])) {
                return new int[] { nums.get(targetSum - arr[i]), i };
            } else {
                nums.put(arr[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}
