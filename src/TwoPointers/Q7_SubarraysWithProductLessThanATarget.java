package TwoPointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q7_SubarraysWithProductLessThanATarget {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { 2, 5, 3, 10 }, 30)); // [[2], [5], [2, 5], [3], [5, 3], [10]]
        System.out.println(solution(new int[] { 8, 2, 6, 5 }, 50));  // [[8], [2], [8, 2], [6], [2, 6], [5], [6, 5]]
    }

    public static List<List<Integer>> solution(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        double product = 1;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left <= right) {
                product /= arr[left++];
            }
            List<Integer> tempList = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr[right]);
                ans.add(new ArrayList<>(tempList));
            }
        }

        return ans;
    }
}
